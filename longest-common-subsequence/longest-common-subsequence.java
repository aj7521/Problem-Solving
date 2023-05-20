class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // return lcs(n-1, m-1, a, b, dp);
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
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int lcs(int i, int j, String str, String srt, int dp[][]){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(str.charAt(i)==srt.charAt(j)){
            return 1 + lcs(i-1, j-1, str, srt, dp);
        }
        return dp[i][j] = Math.max(lcs(i-1, j, str, srt, dp), lcs(i, j-1, str, srt, dp));
    }
}