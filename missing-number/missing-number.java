class Solution {
    public int missingNumber(int[] nums) {
        int pos = 0;
        while(pos < nums.length){
            if(nums[pos] < nums.length && nums[pos] != nums[nums[pos]]){
                swap(nums, pos, nums[pos]);
            }else{
                pos++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}