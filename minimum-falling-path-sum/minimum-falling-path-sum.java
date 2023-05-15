class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minsum = Integer.MAX_VALUE;
        int dp[][] = new int [n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        for(int j=0; j<n; j++){
            int cursum = count(0, j, n, matrix, dp);
            minsum = Math.min(minsum, cursum);
        }
        return minsum;
    }

    public int count(int i, int j, int n, int matrix[][], int dp[][]){
        if(j<0 || j>=n) return Integer.MAX_VALUE;
        if(i==n-1) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int ls = count(i+1, j-1, n, matrix, dp);
        int ds = count(i+1, j, n, matrix, dp);
        int rs = count(i+1, j+1, n, matrix, dp);

        return dp[i][j] = Math.min(Math.min(ls, ds), rs) + matrix[i][j];
    }
}