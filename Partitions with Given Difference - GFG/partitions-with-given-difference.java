//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int mod = (int)(1e9 + 7);
        int total = 0;
        for(int i=0; i<n; i++){
            total += arr[i];
        }
        if((total-d < 0) || (total-d)%2 == 1) return 0;
        int tar = (total - d)/2;
        
        int dp[][] = new int[n][tar+1];
        if(arr[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        
        if(arr[0]!= 0 && arr[0]<=tar) dp[0][arr[0]] = 1;

        for(int i=1; i<n; i++){
            for(int j=0; j<=tar; j++){
                int np = dp[i-1][j];
                int p = 0;
                if(arr[i]<=j) p += dp[i-1][j-arr[i]];
                dp[i][j] = (p + np)%mod ;
            }
        }
        return dp[n-1][tar];
    }
}