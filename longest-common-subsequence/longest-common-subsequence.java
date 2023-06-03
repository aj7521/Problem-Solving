class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return count(n, m, text1, text2, dp);
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