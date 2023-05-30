class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int numOfIslands = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    numOfIslands++;
                    dfs(i, j, n, m, vis, grid);
                }
            }
        }
        return numOfIslands;
    }
    
    public void dfs(int i, int j, int n, int m, boolean vis[][], char grid[][]){
        vis[i][j] = true;
        
        int x[] = {0,1,0,-1};
        int y[] = {1,0,-1,0};
        for(int a=0; a<x.length; a++){
            int xa = i + x[a];
            int ya = j + y[a];
            if(xa>=0 && xa<n && ya>=0 && ya<m && !vis[xa][ya] && grid[xa][ya]=='1'){
                dfs(xa, ya, n, m, vis, grid);
            }
        }
        return;
    }

}
class Pair{
    int x;
    int y;
    Pair(int i, int j){
        x = i;
        y = j;
    }
}