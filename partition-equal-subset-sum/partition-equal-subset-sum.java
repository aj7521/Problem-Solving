class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        int dp[][] = new int [nums.length][sum/2 + 1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return check(nums.length-1, sum/2, nums, dp);
    }

    public boolean check(int i, int x, int arr[], int dp[][]){
        if(x==0) return true;
        if(i==0) return (arr[i]==x);
        if(dp[i][x]!=-1) return dp[i][x]==0?false:true;;
        boolean notpick = check(i-1, x, arr, dp);
        boolean pick = false;
        if(arr[i]<=x){
            pick = check(i-1, x-arr[i], arr, dp);
            dp[i][x]=notpick|pick?1:0;
        }
        return notpick | pick;
    }
}