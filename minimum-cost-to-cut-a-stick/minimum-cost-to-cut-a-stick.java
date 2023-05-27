class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int arr[] = new int[c+2];
        arr[0] = 0;
        arr[arr.length-1] = n;
        int p = 1;
        for(int i=0; i<c; i++){
            arr[p++] = cuts[i];
        }
        Arrays.sort(arr);
        int dp[][] = new int[arr.length][arr.length];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(1, c, arr, dp);
    }

    public int f(int i, int j, int arr[], int dp[][]){
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i; ind<=j; ind++){
            int cost = arr[j+1] - arr[i-1] + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}