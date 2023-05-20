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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int n = N;
        int tar = W;
        int cur[] = new int[tar+1];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // return count(n-1, tar, val, wt, dp);
        for(int i=0; i<tar+1; i++){
            cur[i] = (i/wt[0])*val[0];
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<=tar; j++){
                int np = cur[j];
                int p = 0;
                if(wt[i]<=j) p = val[i] + cur[j-wt[i]];
                cur[j] = Math.max(p, np);
            }
        }
        return cur[tar];
    }
    
    public static int count(int i, int t, int val[], int wt[], int dp[][]){
        if(i==0){
            int mul = t/wt[0];
            return val[0]*mul;
        }
        if(dp[i][t]!=-1) return dp[i][t];
        int np = count(i-1, t, val, wt, dp);
        int p = 0;
        if(wt[i]<=t) p = val[i] + count(i, t-wt[i], val, wt, dp);
        return dp[i][t] = Math.max(p,np);
    }
}