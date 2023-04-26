//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int x[] = {0,1,1,1,0,-1,-1,-1};
    public int y[] = {-1,-1,0,1,1,1,0,-1};
    public int numIslands(char[][] grid) {
        // Code here
        int count = 0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    count++;
                    Pair p = new Pair(i,j);
                    bfs(p, grid, vis);
                }
            }
        }
        return count;
    }
    public void bfs(Pair p, char[][] grid, boolean vis[][])
    {
        Queue<Pair> q = new LinkedList<>();
        q.offer(p);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int k=0; k<size; k++)
            {
                Pair np = q.poll();
                int i = np.r;
                int j = np.c;
                vis[i][j] = true;
                for(int z=0; z<x.length; z++)
                {
                    int xa = i+x[z];
                    int ya = j+y[z];
                    if(isValid(xa,ya,grid) && !vis[xa][ya] && grid[xa][ya]=='1')
                    {
                        vis[xa][ya] = true;
                        q.offer(new Pair(xa,ya));
                    }
                }
            }
        }
    }
    public boolean isValid(int x, int y, char grid[][])
    {
        int gx = grid.length;
        int gy = grid[0].length;
        if(x>=0 && x<gx && y>=0 && y<gy)
        {
            return true;
        }
        return false;
    }
}

class Pair{
    int r;
    int c;
    Pair(int rw, int cw)
    {
        r = rw;
        c = cw;
    }
}