class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        return check(nums, dp);
    }

    public int check(int arr[], int dp[])
    {
        dp[0] = arr[0];
        int neg = 0;

        for(int i=1; i<arr.length; i++)
        {
            int take = arr[i];
            if(i>1) take+=dp[i-2];
            int nontake = 0 + dp[i-1];

            dp[i] = Math.max(take, nontake);
        }
        return dp[arr.length-1];
    }
    
}