class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    dfs(i, j, n, m, vis, grid, 1);
                }
            }
        }
        //top&bottom
        for(int j=0; j<m; j++){
            if(vis[0][j]==0 && grid[0][j]==0) dfs(0, j, n, m, vis, grid, 0);
            if(vis[n-1][j]==0 && grid[n-1][j]==0) dfs(n-1, j, n, m, vis, grid, 0);
        }
        //left&right
        for(int i=0; i<n; i++){
            if(vis[i][0]==0 && grid[i][0]==0) dfs(i, 0, n, m, vis, grid, 0);
            if(vis[i][m-1]==0 && grid[i][m-1]==0) dfs(i, m-1, n, m, vis, grid, 0);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(vis[i][j] + " ");
            }
            System.out.println();
        }
        //getClosedIslands
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]==0){
                    count++;
                    dfs(i, j, n, m, vis, grid, 0);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, int n, int m, int vis[][], int grid[][], int ic){
        vis[i][j] = 1;
        int x[] = {-1,0,1,0};
        int y[] = {0,-1,0,1};
        for(int k=0; k<4; k++){
            int xa = x[k] + i;
            int ya = y[k] + j;
            if(xa>=0 && xa<n && ya>=0 && ya<m && vis[xa][ya]==0 && grid[xa][ya]==ic){
                dfs(xa, ya, n, m, vis, grid, ic);
            }
        }
    }
}