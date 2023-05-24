class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int sum = 0;
        for(int i=1; i<prices.length; i++){
            int cost = prices[i] - mini;
            sum = Math.max(sum, cost);
            mini = Math.min(mini, prices[i]);
        }
        return sum;
    }
}