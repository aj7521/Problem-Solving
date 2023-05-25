class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // return count(0, nums, -1, dp);
        for(int i=n-1; i>=0 ; i--){
            for(int p=i-1; p>=-1; p--){
                int nt = dp[i+1][p+1];
                int t = 0;
                if(p==-1 || nums[i]>nums[p]) t = 1 + dp[i+1][i+1];
                dp[i][p+1] = Math.max(nt, t);
            }
        }
        return dp[0][0];
    }

    // public int count(int i, int arr[], int par, int dp[][]){
    //     if(i==arr.length){
    //         return 0;
    //     }
    //     if(dp[i][par+1] != -1) return dp[i][par+1];
    //     int nt = count(i+1, arr, par, dp);
    //     int t = 0;
    //     if(par==-1 || arr[i]>arr[par]) t = 1 + count(i+1, arr, i, dp);
    //     return dp[i][par+1] = Math.max(nt, t);
    // }
}