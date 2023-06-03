class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int [n][n];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        for(int j=0; j<n; j++){
            
            min = Math.min(min, count(0, j, n, matrix, dp));
        }
        return min;
    }

    public int count(int i, int j, int n, int arr[][], int dp[][]){
        if(i==n-1) return arr[i][j];

        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];

        if(j-1>=0) left = count(i+1, j-1, n, arr, dp);
        if(j+1<n) right = count(i+1, j+1, n, arr, dp);
        int down = count(i+1, j, n, arr, dp);
        return dp[i][j] = Math.min(left, Math.min(down, right)) + arr[i][j];
    }
}