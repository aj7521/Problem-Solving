class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxCount = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memory = new int[matrix.length][matrix[0].length];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int count = dfs(i, j, -1, matrix, memory);
                if(count > maxCount)
                {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }
    public int dfs(int r, int c, int par, int matrix[][], int memory[][])
    {
        int n = matrix.length;
        int m = matrix[0].length;
        if(r<0 || r==n || c<0 || c==m || matrix[r][c] <= par)
        {
            return 0;
        }
        if(memory[r][c] != 0) return memory[r][c];
        int up = 1 + dfs(r + 1, c, matrix[r][c], matrix, memory);
        int right = 1 + dfs(r, c + 1, matrix[r][c], matrix, memory);
        int down = 1 + dfs(r - 1, c, matrix[r][c], matrix, memory);
        int left = 1 + dfs(r, c - 1, matrix[r][c], matrix, memory);
        
        int count = Math.max(Math.max(up,left),Math.max(down, right));
        memory[r][c] = count;
        return count;
    }
}