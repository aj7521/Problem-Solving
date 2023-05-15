class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for(int rows[][]: dp){
            for(int row[]: rows){
                Arrays.fill(row, -1);
            }
        }
        return count(0, 0, n-1, m, n, grid, dp);
    }

    public int count(int m, int n, int grid[][], int dp[][][]){
        for(int i=m-1; i>=0; i--){
            for(int j1=0; j1<n; j1++){
                for(int j2=0; j2<n; j2++){
                    if(i==m-1){
                        if(j1==j2){
                            dp[i][j1][j2] = grid[i][j1];
                        }
                        else
                        {
                            dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
                        }
                    }
                    else
                    {
                        int max = (int)(-1e8);
                        for(int x=-1; x<=1; x++){
                            for(int y=-1; y<=1; y++){
                                int val = 0;
                                if(j1==j2){
                                    val = grid[i][j1];
                                }
                                else{
                                    val = grid[i][j1] + grid[i][j2];
                                }
                                if(j1+x>=0 && j1+x<n && j2+y>=0 && j2+y<n) val += dp[i+1][j1+x][j2+y];
                                max = Math.max(max, val);
                            }
                        }
                        dp[i][j1][j2] = max;
                    }
                }
            }
        }
        return dp[0][0][0];
    }

    public int count(int i, int j1, int j2, int m, int n, int grid[][], int dp[][][]){
        if(j1<0 || j1>=n || j2<0 || j2>=n) return (int)(-1e8);
        if(i==m-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max = (int)(-1e8);
        for(int x=-1; x<=1; x++){
            for(int y=-1; y<=1; y++){
                int val = 0;
                if(j1==j2){
                    val = grid[i][j1];
                }
                else{
                    val = grid[i][j1] + grid[i][j2];
                }
                val += count(i+1, j1+x, j2+y, m, n, grid, dp);
                max = Math.max(max, val);
            }
        }
        return dp[i][j1][j2] = max;
    }
}