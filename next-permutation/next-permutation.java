class Solution {
    public void nextPermutation(int[] nums) {
        int bp = -1;
        int n = nums.length;
        int last = -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                bp = i;
                break;
            }
            else{
                last = nums[i];
            }
        }
        if(bp==-1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int i=n-1; i>=bp; i--){
            if(nums[i]>nums[bp]){
                swap(nums, i, bp);
                break;
            }
        }
        reverse(nums, bp+1, n-1);
        return;
    }

    public void reverse(int arr[], int i, int j){
        int mid = (j+i)/2;
        for(int k=i; k<=mid; k++){
            swap(arr, k, j);
            j--;
        }
        return;
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
}