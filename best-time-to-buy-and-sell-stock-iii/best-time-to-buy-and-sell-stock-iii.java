class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int [2][3];
        int profit = 0;
        for(int i=n-1; i>=0; i--){
                dp[1][1] = Math.max(dp[0][1] - prices[i], dp[1][1]);
                dp[0][1] = Math.max(dp[1][0] + prices[i], dp[0][1]);
                dp[1][2] = Math.max(dp[0][2] - prices[i], dp[1][2]);
                dp[0][2] = Math.max(dp[1][1] + prices[i], dp[0][2]);
        }

        return dp[1][2];
    }
}