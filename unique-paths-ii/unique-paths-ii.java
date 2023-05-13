class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int [m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                dp[i][j] = -1;
            }
        }
        return countPaths(m-1, n-1, grid, dp);
    }

    public int countPaths(int i, int j, int grid[][], int dp[][])
    {
        if(i==0 && j==0 && grid[i][j]==0) return 1;
        if(i<0 || j<0 || grid[i][j]==1) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int left = countPaths(i, j-1, grid, dp);
        int up = countPaths(i-1, j, grid, dp);

        return dp[i][j] = left+up;
    }
}