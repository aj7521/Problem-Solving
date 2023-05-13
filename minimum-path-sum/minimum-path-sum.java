class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                dp[i][j] = -1;
            }
        }
        return count(m-1, n-1, grid, dp);
    }

    public int count(int i, int j, int grid[][], int dp[][])
    {
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];

        int left = count(i, j-1, grid, dp);
        int up = count(i-1, j, grid, dp);

        return dp[i][j] = Math.min(left, up)+grid[i][j];
    }
}