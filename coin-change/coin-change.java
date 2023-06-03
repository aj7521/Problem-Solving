class Solution {
    public int coinChange(int[] coins, int amount) {        
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        int val = count(n-1, coins, amount, dp);
        if(val >= (int)(1e9)){
            return -1;
        }
        return val;
    }

    public int count(int i, int arr[], int sum, int dp[][]){
        if(i==0){
            if(sum%arr[0]==0) return sum/arr[i];
            else return (int)(1e9);
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int nt = count(i-1, arr, sum, dp);
        int t = (int)(1e9);
        if(arr[i]<=sum) t = 1 + count(i, arr, sum-arr[i], dp);

        return dp[i][sum] = Math.min(t, nt);
    }
}