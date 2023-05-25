class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        for(int r[][]: dp){
            for(int row[]: r){
                Arrays.fill(row, -1);
            }
        }
        
        return maxP(0, prices, 1, dp, 2);
    }

    public int maxP(int i, int arr[], int buy, int dp[][][], int k){
        if(k==0) return 0;
        if(i==arr.length){
            return 0;
        }
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
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
        return dp[i][buy][k] = profit;
    }
}