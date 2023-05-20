class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return lcs(n-1, m-1, text1, text2, dp);
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