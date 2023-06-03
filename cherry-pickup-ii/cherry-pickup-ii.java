class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int [n][m][m];
        for(int arr[][]: dp){
            for(int row[]: arr){
                Arrays.fill(row, -1);
            }
        }
        return count(0, 0, m-1, n, m, grid, dp);
    }

    public int count(int i, int j1, int j2, int n, int m, int grid[][], int dp[][][]){
        if(j1<0 || j2<0 || j1>=m || j2>=m) return (int)(-1e8);
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max = (int)(-1e8);
        for(int k=-1; k<=1; k++){
            for(int l=-1; l<=1; l++){
                int val = 0;
                if(j1==j2){
                    val = grid[i][j1];
                }else{
                    val = grid[i][j1] + grid[i][j2];
                } 
                val += count(i+1, j1+k, j2+l, n, m, grid, dp);
                max = Math.max(max, val);
            }
        }
        return dp[i][j1][j2] = max;
    }
}