class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];
        for(int[][] newRow: dp)
        {
            for(int []latrow: newRow)
            {
                Arrays.fill(latrow, -1);
            }
        }
        return help(0,0,c-1,r,c,grid,dp);
    }

    public int help(int i, int j1, int j2, int r, int c, int grid[][], int dp[][][])
    {
        if(j1<0 || j2<0 || j1>=c || j2>=c){
            return (int)(-1e8);
        }
        if(i==r-1)
        {
            if(j1==j2) return grid[i][j1];
            else return (grid[i][j1] + grid[i][j2]);
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = 0;
        for(int a=-1; a<=1; a++)
        {
            for(int b=-1; b<=1; b++)
            {
                int value = 0;
                if(j1==j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += help(i+1, j1+a, j2+b, r, c, grid, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }
}