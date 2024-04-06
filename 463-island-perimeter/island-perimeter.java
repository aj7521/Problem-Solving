class Solution {
    public int[] x = {0,1,0,-1};
    public int[] y = {1,0,-1,0};
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int per = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return dfs(i, j, n, m, grid, vis);
                }
            }
        }
        return 0;
    }
    public int dfs(int i, int j, int n, int m, int[][] grid, boolean[][] vis){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0){
            return 1;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j] = true;
        int count = 0;
        count += dfs(i-1, j, n, m, grid, vis);
        count += dfs(i, j-1, n, m, grid, vis);
        count += dfs(i+1, j, n, m, grid, vis);
        count += dfs(i, j+1, n, m, grid, vis);
        return count;
    }
}