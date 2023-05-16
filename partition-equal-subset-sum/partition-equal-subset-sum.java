class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        int tar = sum/2;
        int n = nums.length;
        boolean dp[][] = new boolean [n][tar + 1];
        
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(nums[0]<=tar){
            dp[0][nums[0]] = true;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<=tar; j++){
                boolean nt = dp[i-1][j];
                boolean t = false;
                if(nums[i]<=j){
                    t = dp[i-1][j-nums[i]];
                }
                dp[i][j] = nt || t;
            }
        }
        return dp[n-1][tar];
    }
}