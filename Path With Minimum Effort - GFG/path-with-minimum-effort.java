//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
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