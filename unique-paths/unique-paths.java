class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        return countPaths(m, n, dp);
    }

    public int countPaths(int m, int n, int dp[][])
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0){
                    dp[i][j] = 1;
                }
                else
                {
                    int left = 0, up = 0;
                    if(j>0) {
                        left = dp[i][j-1];
                    }
                    if(i>0)
                    {
                        up = dp[i-1][j];
                    }
                    dp[i][j] = left + up;
                }
            }
        }
        

        return dp[m-1][n-1];
    }
}