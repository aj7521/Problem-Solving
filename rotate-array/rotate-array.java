class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n==1 || k==0) return;
        k = k % n;
        reverse(0, n-k-1, nums);
        reverse(n-k, n-1, nums);
        reverse(0, n-1, nums);
        return ;
    }

    public void reverse(int i, int j, int arr[]){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return;
    }
}