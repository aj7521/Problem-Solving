class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int dp[][] = new int[n][m];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        int res = maxLines(nums1, n-1, nums2, m-1, dp);
        return res;
    }
    public int maxLines(int[] arr, int i, int[] ar2, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = 0;
        if(arr[i]==ar2[j]){
            left += (1 + maxLines(arr, i-1, ar2, j-1, dp));
        }
        int upL = maxLines(arr, i-1, ar2, j, dp);
        int doL = maxLines(arr, i, ar2, j-1, dp);
        return dp[i][j] = Math.max(upL, Math.max(left, doL));
    }
}