class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1) return -1;
        int[][] path = new int[n][n];
        for(int[] pa: path){
            Arrays.fill(pa, (int)(1e9));
        }
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int l=0; l<size; l++){
                Pair p = pq.poll();
                int dist = p.d;
                int r = p.r;
                int c = p.c;
                if(r==n-1 && c==n-1)
                {
                    return dist+1;
                }
                for(int i=-1; i<=1; i++){
                    for(int j=-1; j<=1; j++){
                        if(i==0 && j==0) continue;
                        int x = r + i;
                        int y = c + j;
                        if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==0){
                            if(path[x][y] > dist+1){
                                path[x][y] = dist+1;
                                pq.offer(new Pair(dist+1, x, y));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
class Pair{
    int d;
    int r;
    int c;
    Pair(int da, int ra, int ca){
        d = da;
        r = ra;
        c = ca;
    }
}