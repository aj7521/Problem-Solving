class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] path = new int[n][m];
        for(int[] pa: path){
            Arrays.fill(pa, (int)(1e9));
        }
        path[0][0] = 0;
        int xa[] = {0,-1,0,1};
        int ya[] = {1,0,-1,0};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                int d = p.d;
                int r = p.r;
                int c = p.c;
                for(int j=0; j<4; j++){
                    int x = r + xa[j];
                    int y = c + ya[j];
                    if(x>=0 && x<n && y>=0 && y<m){
                        int curD = Math.max(d, Math.abs(heights[x][y]-heights[r][c]));
                        if(path[x][y] > curD){
                            path[x][y] = curD;
                            q.offer(new Pair(curD, x, y));
                        }
                    }
                }
            }
        }
        return path[n-1][m-1];
    }
}
class Pair{
    int d, r, c;
    Pair(int da, int ra, int ca){
        d = da;
        r = ra;
        c = ca;
    }
}