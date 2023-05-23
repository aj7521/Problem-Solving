class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i=n; int j=m;
        int lcs = dp[n][m];
        int len = n + m - lcs;
        char arr[] = new char[len];
        int p = len-1;
        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                arr[p--] += a.charAt(i-1);
                i--; j--;
            }
            else if(dp[i][j-1] > dp[i-1][j]){
                arr[p--] += b.charAt(j-1);
                j--;
            }
            else
            {
                arr[p--] += a.charAt(i-1);
                i--;
            }
        }
        while(i>0){
            arr[p--] += a.charAt(i-1);
            i--;
        }
        while(j>0){
            arr[p--] += b.charAt(j-1);
            j--;
        }
        return new String(arr);
    }
}