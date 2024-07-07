class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return maxPoints(0, questions, dp);
    }
    public long maxPoints(int i, int[][] arr, long[] dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        long p = arr[i][0] + maxPoints(i+arr[i][1]+1, arr, dp);
        long np = maxPoints(i+1, arr, dp);
        return dp[i] = Math.max(p, np);
    }
}