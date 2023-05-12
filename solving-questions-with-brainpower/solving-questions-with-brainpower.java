class Solution {
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length];
        for(int i=0; i<dp.length; i++)
        {
            dp[i] = -1;
        }
        long points = check(0, questions, dp);
        return points;
    }

    public long check(int i, int arr[][], long dp[])
    {
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        long pick = arr[i][0] + check(i+arr[i][1]+1, arr, dp);
        long nonpick = check(i+1, arr, dp);
        return dp[i] = Math.max(pick, nonpick);
    }
}