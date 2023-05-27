class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int arr[] = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1') arr[j]++;
                else arr[j] = 0;
                System.out.print(arr[j]);
            }
            System.out.println();
            max = Math.max(lh(arr), max);
        }
        return max;
    }

    public int lh(int arr[]){
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        int n = arr.length;
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || arr[st.peek()] >= arr[i])){
                int h = arr[st.pop()];
                int w;
                if(st.isEmpty()) w = i;
                else w = i - st.peek() - 1;
                maxi = Math.max(maxi, w * h);
            }
            st.push(i);
        }
        return maxi;
    }
}