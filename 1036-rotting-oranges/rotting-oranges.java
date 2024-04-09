class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        //BFS
        int[] xa = {1,0,-1,0};
        int[] ya = {0,1,0,-1};
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                for(int j=0; j<4; j++){
                    int dx = x + xa[j];
                    int dy = y + ya[j];
                    if(dx>=0 && dx<n && dy>=0 && dy<m && grid[dx][dy]==1){
                        grid[dx][dy]=2;
                        q.offer(new Pair(dx, dy));
                        fresh--;
                    }
                }
            }
        }
        if(fresh!=0) return -1;
        return count-1;
    }
}

class Pair{
    int x;
    int y;
    Pair(int xa, int ya){
        x = xa;
        y = ya;
    }
}