class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int [n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0) dp[0][j] = matrix[0][j];
                else{
                    int ls = Integer.MAX_VALUE;
                    int rs = Integer.MAX_VALUE;
                    int ds = Integer.MAX_VALUE;
                    if(j>0) ls = dp[i-1][j-1];
                    ds = dp[i-1][j];
                    if(j<n-1) rs = dp[i-1][j+1];
                    dp[i][j] = Math.min(Math.min(ls, ds), rs) + matrix[i][j];
                }
            }
        }
        int max = dp[n-1][0];
        for(int j=1; j<n; j++){
            max = Math.min(max, dp[n-1][j]);
        }
        return max;
    }

    // public int count(int i, int j, int n, int matrix[][], int dp[][]){
    //     if(j<0 || j>=n) return Integer.MAX_VALUE;
    //     if(i==0) return matrix[0][j];
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int ls = count(i-1, j-1, n, matrix, dp);
    //     int ds = count(i-1, j, n, matrix, dp);
    //     int rs = count(i-1, j+1, n, matrix, dp);

    //     return dp[i][j] = Math.min(Math.min(ls, ds), rs) + matrix[i][j];
    // }
}