class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(i, j, n, m, grid, vis);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int n, int m, char grid[][], boolean vis[][]){
        vis[i][j] = true;
        int x[] = {-1,0,1,0};
        int y[] = {0,-1,0,1};
        for(int r=0; r<4; r++){
            int xa = x[r] + i;
            int ya = y[r] + j;
            if(xa>=0 && xa<n && ya>=0 && ya<m && grid[xa][ya]=='1' && !vis[xa][ya]){
                dfs(xa, ya, n, m, grid, vis);
            }
        }
        return;
    }
}