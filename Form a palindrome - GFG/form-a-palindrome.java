//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String s)
    {
        // code here
        int n = s.length();
        char  ch[] = new char[n];
        int p = n-1;
        for(int i=0; i<n; i++){
            ch[p--] = s.charAt(i);
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
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int lcs = dp[n][n];
        return n - lcs;
    }
}