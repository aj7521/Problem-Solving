class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int count[] = new int[n];
        Arrays.fill(count, 1);
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if(arr[i] > arr[j] && dp[i]==dp[j]+1){
                    count[i] += count[j];
                }
            }
            max = Math.max(dp[i], max);
        }
        int nos = 0;
        for(int i=0; i<n; i++){
            if(dp[i]==max){
                nos+=count[i];
            }
        }
        return nos;
    }
}