class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 1;
        int n = nums.length;
        while(l<n && r<n){
            if(nums[l]==0 && nums[r]!=0){
                swap(nums, l, r);
            }
            else if(nums[l]==0 && nums[r]==0){
                r++;
            }
            else{
                l++;
                r++;
            }
        }
        return;
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}