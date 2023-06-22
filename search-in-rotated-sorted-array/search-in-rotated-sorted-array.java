class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left-sorted
            if(nums[low] <= nums[mid]){
                //if it lies in the sorted part
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid - 1;
                }
                //or not
                else{
                    low = mid + 1;
                }
            }
            //right-sorted
            else{
                //if it lies in the sorted part
                if(nums[mid]<=target && target<=nums[high]){
                    low = mid + 1;
                }
                //or not
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}