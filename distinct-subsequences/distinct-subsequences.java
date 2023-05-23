class Solution {
    public int numDistinct(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        // for(int i=0; i<=n; i++){ 
        //     for(int j=0; j<=m; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return count(n, m, a, b, dp);
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int np = dp[i-1][j];
                int p = 0;
                if(a.charAt(i-1)==b.charAt(j-1)){
                    p = dp[i-1][j-1];
                }
                dp[i][j] = p + np;
            }
        }
        return dp[n][m];
    }

    public int count(int i, int j, String a, String b, int dp[][]){
        if(j==0){
            return 1;
        }
        if(i==0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int np = count(i-1, j, a, b, dp);
        int p = 0;
        if(a.charAt(i-1)==b.charAt(j-1)){
            p = count(i-1, j-1, a, b, dp);
        }
        return dp[i][j] = p + np;
    }
}