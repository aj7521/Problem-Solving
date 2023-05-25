class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return maxP(0, prices, 1, dp);
        // dp[0] = dp[1] = 0;
        // int profit = 0;
        // for(int i=n-1; i>=0; i--){
        //     for(int j=0; j<2; j++){
        //         if(j==1){
        //             int take = dp[0] - arr[i];
        //             int ntake = dp[1];
        //             profit = Math.max(take, ntake);
        //         }
        //         else{
        //             int take = dp[1] + arr[i];
        //             int ntake = dp[0];
        //             profit = Math.max(take, ntake);
        //         }
        //         dp[j] = profit;
        //     }
        // }
        // return dp[1];
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