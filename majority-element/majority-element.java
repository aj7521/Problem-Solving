class Solution {
    public int majorityElement(int[] nums) {
        int me = nums[0];
        int c = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==me){
                c++;
            }
            else{
                c--;
                if(c==0){
                    me = nums[i];
                    c = 1;
                }
            }
        }
        return me;
    }
}