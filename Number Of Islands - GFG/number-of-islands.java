//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    class UnionFind {
        int[] parent;
        int[] weight;
        
        public UnionFind(int num) {
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
    public List<Integer> numOfIslands(int row, int col, int[][] operators) {
        //Your code here
        UnionFind uf = new UnionFind(row*col);
        boolean vis[][] = new boolean[row][col];
        List<Integer> ans = new ArrayList<>();
        int ct = 0;
        for(int i=0; i<operators.length; i++)
        {
            int r = operators[i][0];
            int c = operators[i][1];
            if(vis[r][c])
            {
                ans.add(ct);
                continue;
            }
            vis[r][c] = true;
            ct++;
            int x[] = {0,1,0,-1};
            int y[] = {-1,0,1,0};
            for(int j=0; j<4; j++)
            {
                int xa = r+x[j];
                int ya = c+y[j];
                if(xa>=0 && xa<row && ya>=0 && ya<col && vis[xa][ya])
                {
                    int nodeN = r * col + c;
                    int adjNodeN = xa * col + ya;
                    if(uf.findUpar(nodeN) != uf.findUpar(adjNodeN))
                    {
                        ct--;
                        uf.union(nodeN, adjNodeN);
                    }
                }
            }
            ans.add(ct);
        }
        return ans;
    }
    
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends