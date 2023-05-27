class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][0] = matrix[i][0];
        }
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]!=0){
                    int min = Integer.MAX_VALUE;
                    int top = dp[i-1][j];
                    int tol = dp[i-1][j-1];
                    int left = dp[i][j-1];
                    min = Math.min(left, Math.min(top, Math.min(min, tol)));
                    dp[i][j] = min+1;
                }
            }
        }
        int total = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                total += dp[i][j];
            }
        }
        return total;
    }
}