//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

    public int mod = (int)(1e9) + 7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][] = new int[n][sum+1];
	    for(int row[]: dp){
	        Arrays.fill(row, -1);
	    }
	    return count(n-1, arr, sum, dp);
	} 
	
	public int count(int i, int arr[], int sum, int dp[][]){
        if(i<0) {
            if(sum==0)  return 1;
            return 0;
        }
	    if(dp[i][sum]!=-1) return dp[i][sum]%mod;
	    int np = count(i-1, arr, sum, dp);
	    int p = 0;
	    if(arr[i]<=sum) p = count(i-1, arr, sum-arr[i], dp);
	    
	    return dp[i][sum] = (np + p)%mod;
	}
}