class Solution {
    public int x[] = {-1, 0, 1, 0};
    public int y[] = {0, -1, 0, 1};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 1, vis, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char board[][], int i, int j, int p, boolean vis[][], String word){
        vis[i][j] = true;
        if(p==word.length()){
            return true;
        }
        for(int a=0; a<4; a++){
            int xa = i + x[a];
            int ya = j + y[a];
            if(xa>=0 && xa<board.length && ya>=0 && ya<board[0].length && board[xa][ya]==word.charAt(p) && !vis[xa][ya]){
                if(dfs(board, xa, ya, p+1, vis, word)){
                    return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }
}