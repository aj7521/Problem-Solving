class Solution {
    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int[][][][] dp= new int[55][55][55][55];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    for(int l=0; l<n; l++){
                        dp[i][j][k][l]= -1;
                    }
                }
            }
        }
        
        return Math.max(0,solve(0,0,0,0,n,grid,dp));
    }
    
    public int solve(int r1, int c1, int r2, int c2, int n, int[][] grid, int[][][][] dp){
        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        
        if(dp[r1][c1][r2][c2]!=-1){
            return dp[r1][c1][r2][c2];
        }
        
        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        
        if(r2==n-1 && c2==n-1){
            return grid[r2][c2];
        }
        
        int cherry=0;
        if(r1==r2 && c1==c2){
            cherry= grid[r1][c1];
        } else {
            cherry=grid[r1][c1]+grid[r2][c2];
        }
        
        int f1= solve(r1+1,c1,r2+1,c2,n,grid,dp);
        int f2= solve(r1+1,c1,r2,c2+1,n,grid,dp);
        int f3= solve(r1,c1+1,r2+1,c2,n,grid,dp);
        int f4= solve(r1,c1+1,r2,c2+1,n,grid,dp);
        
        cherry+= Math.max(Math.max(f1,f2), Math.max(f3,f4));
        dp[r1][c1][r2][c2]=cherry;
        return cherry;
    }
}