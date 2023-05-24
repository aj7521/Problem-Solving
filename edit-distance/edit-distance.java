class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return count(n, m, word1, word2, dp);
    }

    public int count(int i, int j, String a, String b, int dp[][]){
        if(i==0) return j;
        if(j==0) return i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(a.charAt(i-1)==b.charAt(j-1)){
            return 0 + count(i-1, j-1, a, b, dp);
        }
        int del = 1 + count(i-1, j, a, b, dp);
        int rep = 1 + count(i-1, j-1, a, b, dp);
        int ins = 1 + count(i, j-1, a, b, dp);
        
        return dp[i][j] = Math.min(del, Math.min(rep, ins));
    }
}