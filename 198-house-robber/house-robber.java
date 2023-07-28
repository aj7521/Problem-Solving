class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxMoney(nums.length-1, nums, dp);
    }

    public int maxMoney(int i, int nums[], int dp[]){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = nums[i] + maxMoney(i-2, nums, dp);
        int notPick = maxMoney(i-1, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}