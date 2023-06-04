class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char ch[] = new char[n];
        for(int i=0; i<n; i++){
            ch[i] = s.charAt(n-i-1);
        }
        String r = new String(ch);
        int dp[][] = new int[n+1][n+1];
        for(int i=0; i<n; i++){
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

    public int count(int i, int j, String s, String r, int dp[][]){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==r.charAt(j-1)){
            return 1 + count(i-1, j-1, s, r, dp);
        }
        return dp[i][j] = Math.max(count(i, j-1, s, r, dp), count(i-1, j, s, r, dp));
    }
}