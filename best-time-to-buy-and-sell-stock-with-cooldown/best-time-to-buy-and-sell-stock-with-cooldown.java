class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        // for(int rows[]: dp){
        //     Arrays.fill(rows, -1);
        // }
        // return maxP(0, prices, 1, dp);
        int profit = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<2; j++){
                if(j==1){
                    int take = dp[i+1][0] - prices[i];
                    int ntake = dp[i+1][1];
                    profit = Math.max(take, ntake);
                }
                else{
                    int take = dp[i+2][1] + prices[i];
                    int ntake = dp[i+1][0];
                    profit = Math.max(take, ntake);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }

    public int maxP(int i, int arr[], int buy, int dp[][]){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            int take = maxP(i+1, arr, 0, dp) - arr[i];
            int ntake = maxP(i+1, arr, 1, dp);
            profit = Math.max(take, ntake);
        }
        else{
            int take = maxP(i+2, arr, 1, dp) + arr[i];
            int ntake = maxP(i+1, arr, 0, dp);
            profit = Math.max(take, ntake);
        }
        return dp[i][buy] = profit;
    }
}