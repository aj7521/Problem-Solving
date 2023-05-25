class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        int profit = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<2; j++){
                for(int k=1; k<=2; k++){
                    if(j==1){
                        int take = dp[i+1][0][k] - prices[i];
                        int ntake = dp[i+1][1][k];
                        profit = Math.max(take, ntake);
                    }
                    else{
                        int take = dp[i+1][1][k-1] + prices[i];
                        int ntake = dp[i+1][0][k];
                        profit = Math.max(take, ntake);
                    }
                    dp[i][j][k] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public int maxP(int i, int arr[], int buy, int dp[][], int k){
        if(k==0) return 0;
        if(i==arr.length){
            return 0;
        }
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            int take = maxP(i+1, arr, 0, dp, k) - arr[i];
            int ntake = maxP(i+1, arr, 1, dp, k);
            profit = Math.max(take, ntake);
        }
        else{
            int take = maxP(i+1, arr, 1, dp, k-1) + arr[i];
            int ntake = maxP(i+1, arr, 0, dp, k);
            profit = Math.max(take, ntake);
        }
        return profit;
    }
}