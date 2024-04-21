class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return get(n, dp);
    }

    public int get(int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = get(n-1, dp) + get(n-2, dp);
    }
}