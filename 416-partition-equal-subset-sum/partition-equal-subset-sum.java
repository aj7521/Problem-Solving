class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        int half = sum/2;
        int[][] dp = new int[n][half+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return sum%2==0?isPossible(n-1, half, nums, dp):false;
    }
    public boolean isPossible(int i, int sum, int[] arr, int[][] dp){
        if(sum==0) return true;
        if(i==0) return arr[i]==sum;
        if(dp[i][sum]!=-1) return dp[i][sum]==0?false:true; 
        boolean notPick = isPossible(i-1, sum, arr, dp);
        boolean pick = false;
        if(sum >= arr[i]){
            pick = isPossible(i-1, sum-arr[i], arr, dp);
            dp[i][sum] = pick | notPick ? 1 : 0;
        }
        return pick||notPick;
    }
}