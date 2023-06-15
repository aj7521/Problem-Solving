class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]==i || nums[i]==nums.length){
                i++;
            }
            else{
                swap(nums, i, nums[i]);
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=j){
                return j;
            }
        }
        return nums.length;
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
}