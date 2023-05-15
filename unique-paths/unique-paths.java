class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        // for(int row[]: dp){
        //     Arrays.fill(row, -1);
        // }
        return countPaths(m, n, dp);
    }

    // public int countPaths(int m, int n, int dp[][])
    // {
    //     if(m<0 || n<0) return 0;
    //     if(m==0 && n==0) return 1;
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     int left = countPaths(m, n-1, dp);
    //     int up = countPaths(m-1, n, dp);
    //     return dp[m][n] = left+up;
    // }

    public int countPaths(int m, int n, int dp[][]){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int left = 0, up = 0;
                    if(j>0) left = dp[i][j-1];
                    if(i>0) up = dp[i-1][j];
                    dp[i][j] = left+up;
                }
            }
        }
        return dp[m-1][n-1];

    }
}