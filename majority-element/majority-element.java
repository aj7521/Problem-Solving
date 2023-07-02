class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(count==0){
                ele = nums[i];
                count = 1;
            }
            else if(ele == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        //checking
        count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == ele){
                count++;
            }
        }

        if(count > (nums.length/3)){
            return ele;
        }
        return -1;
    }
}