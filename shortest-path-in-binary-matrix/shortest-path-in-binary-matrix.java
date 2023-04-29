class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int dist[][] = new int [n][n];
        if(grid[0][0]==1) return -1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                dist[i][j] = (int)(1e9);
            }
        }
        int x[] = {0,1,1,1,0,-1,-1,-1};
        int y[] = {-1,-1,0,1,1,1,0,-1};
        q.offer(new Pair(0,0,0));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int d = p.d;
            int r = p.r;
            int c = p.c;
            if(r==n-1 && c==n-1)
            {
                return d+1;
            }
            for(int i=0; i<x.length; i++)
            {
                int xa = r + x[i];
                int ya = c + y[i];
                if(xa>=0 && xa<n && ya>=0 && ya<n && grid[xa][ya]==0)
                {
                    if(dist[xa][ya] > d+1)
                    {
                        dist[xa][ya] = d+1;
                        q.offer(new Pair(d+1, xa, ya));
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
    Pair(int dis, int row, int col)
    {
        d = dis;
        r = row;
        c = col;
    }
}