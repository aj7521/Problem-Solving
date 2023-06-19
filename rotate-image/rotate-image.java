class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i==j){
                    continue;
                }
                else{
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        //reverse
        for(int row[]: matrix){
            reverse(row, n);
        }

        return;
    }

    public void reverse(int arr[], int n){
        int mid = n/2;
        int j = n-1;
        for(int i=0; i<mid; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
}