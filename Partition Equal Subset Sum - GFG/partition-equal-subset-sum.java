//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += arr[i];
        }
        if(totalSum%2!=0) return 0;
        int dp[][] = new int[n][totalSum/2 + 1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return count(n-1, arr, totalSum/2, dp);
    }
    
    public static int count(int i, int arr[], int sum, int dp[][]){
        if(sum==0) return 1;
        if(i==0){
            if(sum-arr[i]==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int np = count(i-1, arr, sum, dp);
        int p = 0;
        if(arr[i] <= sum){
            p = count(i-1, arr, sum-arr[i], dp);
        }
        return dp[i][sum] =  p|np;
    }
}