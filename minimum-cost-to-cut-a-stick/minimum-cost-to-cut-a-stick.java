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
        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){
                if(i>j) continue;
                int min = Integer.MAX_VALUE;
                for(int ind=i; ind<=j; ind++){
                    int cost = arr[j+1] - arr[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

    public int f(int i, int j, int arr[], int dp[][]){
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i; ind<=j; ind++){
            int len = arr[j+1] - arr[i-1];
            int cost =  len + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}