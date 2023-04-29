class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        int x[] = {0,1,0,-1};
        int y[] = {-1,0,1,0};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.d-b.d);
        pq.offer(new Tuple(0,0,0));
        while(!pq.isEmpty())
        {
            Tuple t = pq.poll();
            int d = t.d;
            int r = t.r;
            int c = t.c;
            if(r==n-1 && c==m-1) return d;
            for(int i=0; i<x.length; i++)
            {
                int xa = r + x[i];
                int ya = c + y[i];
                if(xa>=0 && xa<n && ya>=0 && ya<m)
                {
                    int da = Math.max(d, Math.abs(heights[xa][ya] - heights[r][c]));
                    if(dist[xa][ya] > da)
                    {
                        dist[xa][ya] = da;
                        pq.offer(new Tuple(da,xa,ya));
                    }                  
                }
            }
        }
        return 0;
    }
}
class Tuple{
    int d;
    int r;
    int c;
    Tuple(int ds, int rs, int cs)
    {
        d = ds;
        r = rs;
        c = cs;
    }
}