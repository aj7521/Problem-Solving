class Solution {
    public int maxCoins(int[] cuts) {
        int c = cuts.length;
        int arr[] = new int[c+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        int p = 1;
        for(int i=0; i<c; i++){
            arr[p++] = cuts[i];
        }
        int dp[][] = new int[arr.length][arr.length];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(1, c, arr, dp);
    }
    public int f(int i, int j, int arr[], int dp[][]){
        if(i>j) return 0;
        int max = Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i; ind<=j; ind++){
            int len = arr[j+1] * arr[ind] * arr[i-1];
            int cost =  len + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}