//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        int ans[][] = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        int dist = 0;
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(grid[i][j]==1)
                {
                    vis[i][j] = -1;
                    q.offer(new Pair(i,j));
                }
            }
        }
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
                    if(rx>=0 && rx<r && cx>=0 && cx<c && grid[rx][cx]==0 && vis[rx][cx]==0)
                    {
                        vis[rx][cx] = 1;
                        grid[rx][cx] = dist;
                        q.offer(new Pair(rx, cx));
                    }
                }
            }
        }
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(vis[i][j]==-1)
                {
                    grid[i][j] = 0;
                }
            }
        }
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