class Solution
{
    public int[][] updateMatrix(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        int dist = 0;
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(grid[i][j]==0)
                {
                    vis[i][j] = -1;
                    q.offer(new Pair(i,j));
                }
            }
        }
        // for(int i=0; i<r; i++)
        // {
        //     for(int j=0; j<c; j++)
        //     {
        //         System.out.print(vis[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int x[] = {0,1,0,-1};
        int y[] = {-1,0,1,0};
        while(!q.isEmpty())
        {
            int size = q.size();
            dist++;
            for(int i=0; i<size; i++)
            {
                Pair p = q.poll();
                int rp = p.r;
                int cp = p.c;
                for(int j=0; j<4; j++)
                {
                    int rx = rp + x[j];
                    int cx = cp + y[j];
                    if(rx>=0 && rx<r && cx>=0 && cx<c && grid[rx][cx]==1 && vis[rx][cx]==0)
                    {
                        System.out.println(rp + " " + cp + " " + rx + " " + cx + " " + dist);
                        vis[rx][cx] = 1;
                        grid[rx][cx] = dist;
                        q.offer(new Pair(rx, cx));
                    }
                }
            }
        }
        // for(int i=0; i<r; i++)
        // {
        //     for(int j=0; j<c; j++)
        //     {
        //         if(vis[i][j]==-1)
        //         {
        //             grid[i][j] = 0;
        //         }
        //     }
        // }
        return grid;
    }
}

class Pair{
    int r;
    int c;
    Pair(int rx, int cx)
    {
        r = rx;
        c = cx;
    }
}