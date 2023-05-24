class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int dp[][] = new int[n+1][m+1];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // return count(n, m, word1, word2, dp);
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    int del = 1 + dp[i-1][j];
                    int rep = 1 + dp[i-1][j-1];
                    int ins = 1 + dp[i][j-1];
                    dp[i][j] = Math.min(del, Math.min(rep, ins));
                }
            }
        }
        return dp[n][m];
    }

    // public int count(int i, int j, String a, String b, int dp[][]){
    //     if(i==0) return j;
    //     if(j==0) return i;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(a.charAt(i-1)==b.charAt(j-1)){
    //         return 0 + count(i-1, j-1, a, b, dp);
    //     }
    //     int del = 1 + count(i-1, j, a, b, dp);
    //     int rep = 1 + count(i-1, j-1, a, b, dp);
    //     int ins = 1 + count(i, j-1, a, b, dp);
        
    //     return dp[i][j] = Math.min(del, Math.min(rep, ins));
    // }
}