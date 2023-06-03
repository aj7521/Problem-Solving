class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int first = count(n-2, 0, nums, dp);
        Arrays.fill(dp, -1);
        int second = count(n-1, 1, nums, dp);
        return Math.max(first, second);
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