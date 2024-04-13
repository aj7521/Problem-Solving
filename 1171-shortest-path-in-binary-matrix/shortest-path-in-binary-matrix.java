class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.w-b.w);
        boolean[][] vis = new boolean[n][n];
        if(grid[0][0]==0){
            pq.offer(new Tuple(0,0,0));
            vis[0][0] = true;
        }
        int min = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0; i<size; i++){
                Tuple t = pq.poll();
                int row = t.r;
                int col = t.c;
                int dis = t.w;
                if(row==n-1 && col==n-1){
                    min = Math.min(min, dis);
                }
                for(int r=-1; r<=1; r++){
                    for(int c=-1; c<=1; c++){
                        int ra = row + r;
                        int ca = col + c;
                        if(ra>=0 && ra<n && ca>=0 && ca<n && !vis[ra][ca] && grid[ra][ca]==0){
                            vis[ra][ca] = true;
                            pq.offer(new Tuple(ra, ca, dis+1));
                        }
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min+1;
    }
}
class Tuple{
    int r;
    int c;
    int w;
    Tuple(int ra, int ca, int wa){
        r = ra;
        c = ca;
        w = wa;
    }
}