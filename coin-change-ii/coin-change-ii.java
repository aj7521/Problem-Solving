class Solution {
    public int change(int tar, int[] arr) {
        int dp[][] = new int[arr.length][tar+1];
        int n = arr.length;
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        // int val = count(n-1, tar, arr, dp);
        // return val;

        for(int i=0; i<=tar; i++){
            if(i%arr[0]==0) dp[0][i] = 1;
        }
        

        for(int i=1; i<n; i++){
            for(int j=0; j<=tar; j++){
                int np = dp[i-1][j];
                int p = 0;
                if(arr[i]<=j) p = dp[i][j-arr[i]];
                dp[i][j] = np + p;
            }
        }
        return dp[n-1][tar];
    }

    public int count(int i, int t, int arr[], int dp[][]){
        if(i==0){
            if(t%arr[i]==0) return 1;
            else return 0;
        }
        if(dp[i][t]!=-1) return dp[i][t];

        int np = count(i-1, t, arr, dp);
        int p = 0;
        if(arr[i]<=t) p = count(i, t-arr[i], arr, dp);
        return dp[i][t] = np + p;
    }
}