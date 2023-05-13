class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int dp[][] = new int [n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return count(0, 0, n, t, dp);
    }

    public int count(int i, int j, int n, List<List<Integer>> t, int dp[][])
    {
        if(i==n-1) return t.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = count(i+1, j, n, t, dp);
        int slant = count(i+1, j+1, n, t, dp);
        
        return dp[i][j] = Math.min(down, slant) + t.get(i).get(j);
    }
}