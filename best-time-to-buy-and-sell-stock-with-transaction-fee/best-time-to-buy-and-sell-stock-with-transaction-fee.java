class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return profit(0, 1, prices, fee, dp);
    }

    public int profit(int i, int buy, int arr[], int fees, int dp[][]){
        if(i==arr.length){
            return 0;
        }
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            int take = profit(i+1, 0, arr, fees, dp) - arr[i];
            int nottake = profit(i+1, 1, arr, fees, dp);
            profit = Math.max(take, nottake);
        }
        else{
            int take = profit(i+1, 1, arr, fees, dp) + arr[i] - fees;
            int nottake = profit(i+1, 0, arr, fees, dp);
            profit = Math.max(take, nottake);
        }
        return dp[i][buy] = profit;
    }
}