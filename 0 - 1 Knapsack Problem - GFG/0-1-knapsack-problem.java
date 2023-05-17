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
         int dp[][] = new int[W+1][n];
         for(int row[]: dp){
             Arrays.fill(row, -1);
         }
         return count(W, n-1, wt, val, dp);
    } 
    
    static int count(int w, int i, int wt[], int val[], int dp[][]){
        if(i==0){
            if(wt[0]<=w) return val[0];
            else return 0;
        }
        if(dp[w][i]!=-1) return dp[w][i];
        int np = count(w, i-1, wt, val, dp);
        int p = 0;
        if(wt[i]<=w) p = val[i] + count(w-wt[i], i-1, wt, val, dp);
        
        return dp[w][i] = Math.max(p, np);
    }
}


