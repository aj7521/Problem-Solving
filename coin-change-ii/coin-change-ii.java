class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return count(n-1, coins, amount, dp);
    }

    public int count(int i, int arr[], int sum, int dp[][]){
        if(i==0){
            if(sum%arr[i]==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int nt = count(i-1, arr, sum, dp);
        int t = 0;
        if(arr[i]<=sum) t = count(i, arr, sum-arr[i], dp);

        return dp[i][sum] = t + nt;
    }
}