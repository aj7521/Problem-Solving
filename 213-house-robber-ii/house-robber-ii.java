class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i=1; i<n-1; i++){
            int p = arr[i];
            if(i>1) p += dp[i-2];
            int np = dp[i-1];
            dp[i] = Math.max(p, np);
        }
        int val1 = dp[n-2];
        Arrays.fill(dp, 0);
        dp[1] = arr[1];
        for(int i=2; i<n; i++){
            int p = arr[i];
            if(i>1) p += dp[i-2];
            int np = dp[i-1];
            dp[i] = Math.max(p, np);
        }
        int val2 = dp[n-1];
        return Math.max(val1, val2);
    }

    public int count(int i, int last, int arr[], int dp[]){
        
        if(i<last) return 0;
        if(i==last) return arr[i];
        if(dp[i]!=-1) return dp[i];
        int nt = count(i-1, last, arr, dp);
        int t = arr[i] + count(i-2, last, arr, dp);
        return dp[i] = Math.max(t, nt);
    }
}