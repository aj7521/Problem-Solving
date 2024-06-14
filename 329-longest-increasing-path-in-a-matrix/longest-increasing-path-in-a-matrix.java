class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] maxDist = new int[m][n];
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, maxDist, matrix));
            }
        }
        return ans;
    }
    int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    private int dfs(int x, int y, int[][] maxDist, int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 1;
        if (maxDist[x][y] != 0)
            return maxDist[x][y];

        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && matrix[i][j] > matrix[x][y]) {
                ans = Math.max(ans, 1 + dfs(i, j, maxDist, matrix));
            }
        }
        
        maxDist[x][y] = ans;
        return ans;
    }
}