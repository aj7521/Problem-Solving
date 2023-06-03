//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int matrix[][])
    {
        // code here
        int n = N;
        int min = Integer.MIN_VALUE;
        int dp[][] = new int [n][n];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        for(int j=0; j<n; j++){
            
            min = Math.max(min, count(0, j, n, matrix, dp));
        }
        return min;
    }
    public static int count(int i, int j, int n, int arr[][], int dp[][]){
        if(i==n-1) return arr[i][j];

        int left=Integer.MIN_VALUE;
        int right=Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];

        if(j-1>=0) left = count(i+1, j-1, n, arr, dp);
        if(j+1<n) right = count(i+1, j+1, n, arr, dp);
        int down = count(i+1, j, n, arr, dp);
        return dp[i][j] = Math.max(left, Math.max(down, right)) + arr[i][j];
    }
}