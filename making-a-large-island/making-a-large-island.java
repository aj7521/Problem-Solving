class Solution {
    class DisjointSet {
        int[] parent;
        int[] weight;
        
        public DisjointSet(int num) {
            parent = new int[num];
            weight = new int[num];
            for(int i =  0; i < num; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public void union(int a, int  b) {
            int rootA = findUpar(a);
            int rootB = findUpar(b);
            if (rootA == rootB) {
                return;
            }
            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            } else {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            }
        }
        public int findUpar(int a) {
            if (parent[a] == a) {
                return a;
            }
            parent[a] = findUpar(parent[a]);
            return parent[a];
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int x[] = {0,1,0,-1};
        int y[] = {-1,0,1,0};
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==0)
                {
                    continue;
                }
                for(int k=0; k<4; k++)
                {
                    int xa = i + x[k];
                    int ya = j + y[k];
                    if(xa>=0 && xa<n && ya>=0 && ya<n && grid[xa][ya]==1)
                    {
                        int node = i * n + j;
                        int adjnode = xa * n + ya;
                        ds.union(node, adjnode);
                    }
                }
            }
        }
        int maxSum = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    Set<Integer> set = new HashSet<>();
                    for(int k=0; k<4; k++)
                    {
                        int xa = i + x[k];
                        int ya = j + y[k];
                        if(xa>=0 && xa<n && ya>=0 && ya<n && grid[xa][ya]==1)
                        {
                            int node = xa * n + ya;
                            int ulpnode = ds.findUpar(node);
                            set.add(ulpnode);
                        }
                    }
                    int cursum = 0;
                    for(Integer z: set)
                    {
                        cursum += ds.weight[z];
                    }
                    maxSum = Math.max(maxSum, cursum+1);
                }
            }
        }
        for(int i=0; i<n*n; i++)
        {
            maxSum = Math.max(maxSum, ds.weight[ds.findUpar(i)]);
        }
        return maxSum;
    }
}