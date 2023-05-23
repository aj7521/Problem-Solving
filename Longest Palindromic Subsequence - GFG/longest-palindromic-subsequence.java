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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s)
    {
        int n  = s.length();
        char ch[] = new char[n];
        int p = n-1;
        for(int i=0; i<n; i++){
            ch[p] = s.charAt(i);
            p--;
        }
        String r = new String(ch);
        int dp[][] = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        return dp[n][n];
    }
}