class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n==0 && m==0) return ans;
        boolean pc[][] = new boolean[n][m];
        boolean at[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            dfs(i, 0, n, m, Integer.MIN_VALUE, pc, heights);
            dfs(i, m-1, n, m, Integer.MIN_VALUE, at, heights);
        }

        for(int i=0; i<m; i++){
            dfs(0, i, n, m, Integer.MIN_VALUE, pc, heights);
            dfs(n-1, i, n, m, Integer.MIN_VALUE, at, heights);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pc[i][j] && at[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    public int x[] = {0,1,0,-1};
    public int y[] = {-1,0,1,0};

    public void dfs(int i, int j, int n, int m, int prev, boolean ocean[][], int heights[][]){
        if(i<0 || i>=n || j<0 || j>=m) return;
        if(heights[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        
        for(int xi=0; xi<4; xi++){
            int xa = x[xi] + i;
            int ya = y[xi] + j;
            dfs(xa, ya, n, m, heights[i][j], ocean, heights);
        }
    }
}