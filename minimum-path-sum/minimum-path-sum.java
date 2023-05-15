class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        // for(int i=0; i<m; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        return count(m, n, grid, dp);
    }

    // public int count(int i, int j, int grid[][], int dp[][])
    // {
    //     if(i==0 && j==0) return grid[i][j];
    //     if(i<0 || j<0) return Integer.MAX_VALUE;
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int left = count(i, j-1, grid, dp);
    //     int up = count(i-1, j, grid, dp);

    //     return dp[i][j] = Math.min(left, up)+grid[i][j];
    // }

    public int count(int m, int n, int grid[][], int dp[][]){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                    if(j>0) left = dp[i][j-1];
                    if(i>0) up = dp[i-1][j];
                    dp[i][j] = Math.min(left, up)+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}