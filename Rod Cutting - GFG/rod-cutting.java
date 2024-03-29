//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int cur[] = new int[n+1];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // return count(n-1, n, price, dp);
        for(int i=0; i<=n; i++){
            cur[i] = i * price[0];
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<=n; j++){
                int np = cur[j];
                int p = Integer.MIN_VALUE;
                int curlen = i+1;
                if(curlen <= j) p = price[i] + cur[j-curlen];
                cur[j] = Math.max(p, np);
            }
        }
        return cur[n];
    }
    
    public int count(int i, int len, int price[], int dp[][]){
        if(i==0) return len*price[0];
        if(dp[i][len]!=-1) return dp[i][len];
        int np = count(i-1, len, price, dp);
        int p = Integer.MIN_VALUE;
        int curlen = i+1;
        if(curlen<=len) p = price[i] + count(i, len-curlen, price, dp);
        return dp[i][len] = Math.max(p, np);
    }
}