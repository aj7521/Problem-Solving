class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        if(matrix.length == 0 || matrix[0].length == 0) return matrix;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int p = 1;
        
        while(true){
            for(int i = left; i <= right; i++) 
            {
                matrix[top][i] = p;
                p++;
            }
            top++;
            if(left > right || top > bottom) break;
            
            for(int i = top; i <= bottom; i++){
                matrix[i][right] = p;
                p++;
            }
            right--;
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--){
                matrix[bottom][i] = p;
                p++;
            }
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--){
                matrix[i][left] = p;
                p++;
            }
            left++;
            if(left > right || top > bottom) break;
        }
        
        return matrix;
    }
}