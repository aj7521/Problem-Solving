class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return count(0, 0, n, triangle, dp);
    }

    public int count(int i, int j, int n, List<List<Integer>> triangle, int dp[][]){
        if(i==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = triangle.get(i).get(j) + count(i+1, j, n, triangle, dp);
        int right = triangle.get(i).get(j) + count(i+1, j+1, n, triangle, dp);

        return dp[i][j] = Math.min(down, right);
    }
}