class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        int n = moves.length();
        for(int i=0; i<n; i++){
            char move = moves.charAt(i);
            if(move=='U'){
                y++;
            }
            else if(move=='D'){
                y--;
            }
            else if(move=='L'){
                x--;
            }
            else{
                x++;
            }
        }
        if(x==0 && y==0) return true;
        return false;
    }
}