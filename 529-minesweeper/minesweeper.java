class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length, m = board[0].length;
        int x = click[0], y = click[1];
        if(board[x][y]=='M'){
            board[x][y]='X';
            return board;
        }
        else{
            int count = 0;
            for(int i=-1; i<=1; i++){
                for(int j=-1; j<=1; j++){
                    int xa = x+i;
                    int ya = y+j;
                    if(xa>=n || xa<0 || ya>=m || ya<0) continue;
                    if(board[xa][ya]=='M') count++;
                }
            }
            if(count>0){
                board[x][y] = (char)(count+'0');
            }
            else{
                board[x][y] = 'B';
                for(int i=-1; i<=1; i++){
                    for(int j=-1; j<=1; j++){
                        int xa = x+i;
                        int ya = y+j;
                        if(xa>=n || xa<0 || ya>=m || ya<0) continue;
                        if(board[xa][ya]=='E'){
                            updateBoard(board, new int[]{xa,ya});
                        }
                    }
                }
            }
        }
        return board;
    }
}