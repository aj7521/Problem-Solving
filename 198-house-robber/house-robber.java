class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            int np = dp[i-1];
            int p = arr[i];
            if(i>1) p += dp[i-2];
            dp[i] = Math.max(p, np);
        }
        return dp[n-1];
        // Arrays.fill(dp, -1);
        // return get(n-1, nums, dp);
    }

    public int get(int i, int arr[], int dp[]){
        if(i<0) return 0;
        if(i==0) return arr[i];
        if(dp[i]!=-1) return dp[i];
        int np = get(i-1, arr, dp);
        int p = arr[i] + get(i-2, arr, dp);

        return dp[i] = Math.max(p, np);
    }
}