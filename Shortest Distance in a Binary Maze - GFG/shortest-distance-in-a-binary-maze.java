//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] src, int[] des) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int dist[][] = new int [n][m];
        if(grid[src[0]][src[1]]==0) return -1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                dist[i][j] = (int)(1e9);
            }
        }
        int x[] = {0,1,0,-1};
        int y[] = {-1,0,1,0};
        q.offer(new Pair(0,src[0],src[1]));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int d = p.d;
            int r = p.r;
            int c = p.c;
            if(r==des[0] && c==des[1])
            {
                return d;
            }
            for(int i=0; i<x.length; i++)
            {
                int xa = r + x[i];
                int ya = c + y[i];
                if(xa>=0 && xa<n && ya>=0 && ya<m && grid[xa][ya]==1)
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