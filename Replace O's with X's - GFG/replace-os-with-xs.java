//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int x[] = {0,1,0,-1};
    int y[] = {-1,0,1,0};
    public char[][] fill(int nx, int mx, char[][] board) {
        int n = nx;
        int m = mx;
        boolean vis[][] = new boolean[n][m];
        //top-bottom
        for(int i=0; i<m; i++)
        {
            //top
            if(!vis[0][i] && board[0][i]=='O')
            {
                dfs(0, i, vis, board);
            }
            //bottom
            if(!vis[n-1][i] && board[n-1][i]=='O')
            {
                dfs(n-1, i, vis, board);
            }
        }
        //left-right
        for(int i=0; i<n; i++)
        {
            //left
            if(!vis[i][0] && board[i][0]=='O')
            {
                dfs(i, 0, vis, board);
            }
            //right
            if(!vis[i][m-1] && board[i][m-1]=='O')
            {
                dfs(i, m-1, vis, board);
            }
        }
        
        //mark all remaining x
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
            {
                if(board[i][j]=='O' && !vis[i][j])
                {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    public void dfs(int i, int j, boolean vis[][], char board[][])
    {
        vis[i][j] = true;
        int n = board.length;
        int m = board[0].length;
        for(int a=0; a<4; a++)
        {
            int r = i + x[a];
            int c = j + y[a];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && board[r][c]=='O')
            {
                dfs(r, c, vis, board);
            }
        }
    }
}