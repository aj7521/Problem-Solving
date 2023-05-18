class Solution {
    public int coinChange(int[] coins, int tar) {
        int dp[][] = new int[coins.length][tar+1];
        int n = coins.length;
        for(int i=0; i<tar+1; i++){
            if(i%coins[0]==0){
                dp[0][i] = i/coins[0];
            }
            else dp[0][i] = (int)(1e9);
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=tar; j++){
                int np = dp[i-1][j];
                int p = Integer.MAX_VALUE;
                if(coins[i]<=j) p = 1 + dp[i][j-coins[i]];
                dp[i][j] = Math.min(p, np);
            }
        }
        return dp[n-1][tar]>=(int)(1e9)?-1:dp[n-1][tar];
    }
}