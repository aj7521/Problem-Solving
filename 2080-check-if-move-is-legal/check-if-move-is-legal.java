class Solution {
    public boolean checkMove(char[][] board, int r, int c, char color) {
        boolean flag = false;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                flag = flag || dfs(board, r, c, color, i, j, 0);
            }
        }
        return flag;
        
    }
     private boolean dfs(char[][] board, int r, int c, char color, int r2, int c2, int count) {
       r += r2;
       c += c2;

       if (r < 0 || c < 0 || r > 7 || c > 7 || board[r][c] == '.') return false;
       if (board[r][c] == color ) return count >= 1;
       return dfs(board, r, c, color, r2, c2, ++count);
     }
}