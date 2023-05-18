class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        int val = coin(coins.length-1, coins, amount, dp);
        if(val >= (int)(1e9)){
            return -1;
        }
        return val;
    }

    public int coin(int i, int coins[], int t, int dp[][]){
        if(i==0){
            if(t%coins[i]==0) return t/coins[i];
            else return (int)(1e9);
        }
        if(dp[i][t]!=-1) return dp[i][t];
        int np = coin(i-1, coins, t, dp);
        int p = Integer.MAX_VALUE;
        if(coins[i]<=t) p = 1 + coin(i, coins, t-coins[i], dp);

        return dp[i][t] = Math.min(p, np);
    }
}