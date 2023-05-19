class Solution {
    public int change(int tar, int[] coins) {
        int dp[][] = new int[coins.length][tar+1];
        int n = coins.length;
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        int val = count(n-1, tar, coins, dp);
        return val;
    }

    public int count(int i, int t, int arr[], int dp[][]){
        if(t==0) return 1;
        if(i==0){
            if(t%arr[i]==0) return 1;
            else return 0;
        }
        if(dp[i][t]!=-1) return dp[i][t];

        int np = count(i-1, t, arr, dp);
        int p = 0;
        if(arr[i]<=t) p = count(i, t-arr[i], arr, dp);
        return dp[i][t] = np + p;
    }
}