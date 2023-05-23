class Solution {
    public int numDistinct(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){ 
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        return count(n-1, m-1, a, b, dp);
    }

    public int count(int i, int j, String a, String b, int dp[][]){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int np = count(i-1, j, a, b, dp);
        int p = 0;
        if(a.charAt(i)==b.charAt(j)){
            p = count(i-1, j-1, a, b, dp);
        }
        return dp[i][j] = p + np;
    }
}