//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int x[] = {0,1,0,-1};
    int y[] = {-1,0,1,0};
    public int numberOfEnclaves(int[][] board) {
        int count = 0;
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        //top-bottom
        for(int i=0; i<m; i++)
        {
            //top
            if(!vis[0][i] && board[0][i]==1)
            {
                dfs(0, i, vis, board);
            }
            //bottom
            if(!vis[n-1][i] && board[n-1][i]==1)
            {
                dfs(n-1, i, vis, board);
            }
        }
        //left-right
        for(int i=0; i<n; i++)
        {
            //left
            if(!vis[i][0] && board[i][0]==1)
            {
                dfs(i, 0, vis, board);
            }
            //right
            if(!vis[i][m-1] && board[i][m-1]==1)
            {
                dfs(i, m-1, vis, board);
            }
        }
        
        //mark all remaining x
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
            {
                if(board[i][j]==1 && !vis[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, boolean vis[][], int board[][])
    {
        vis[i][j] = true;
        if(board[i][j]==1) board[i][j]=0;
        int n = board.length;
        int m = board[0].length;
        for(int a=0; a<4; a++)
        {
            int r = i + x[a];
            int c = j + y[a];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && board[r][c]==1)
            {
                dfs(r, c, vis, board);
            }
        }
    }
}
