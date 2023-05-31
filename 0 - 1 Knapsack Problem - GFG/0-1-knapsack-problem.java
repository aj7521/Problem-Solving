//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[n][W+1];
         for(int row[]: dp){
             Arrays.fill(row, -1);
         }
         return count(0, W, wt, val, n, dp);
    }
    
    static int count(int i, int W, int w[], int v[], int n, int dp[][]){
        if(i==n) return 0;
        if(dp[i][W]!=-1) return dp[i][W];
        int notPick = count(i+1, W, w, v, n, dp);
        int pick = 0;
        if(W >= w[i]) pick = v[i] + count(i+1, W-w[i], w, v, n, dp);
        return dp[i][W] = Math.max(pick, notPick);
    }
}


