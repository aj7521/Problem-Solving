class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        int low = nums[0], high = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]-nums[i-1]!=1){
                String temp = new String();
                if(low<high){
                    temp += low;
                    temp += "->";
                    temp += high;
                    
                }
                else{
                    temp += low;
                }
                ans.add(temp); 
                low = nums[i];
                high = nums[i];
            }
            else{
                high = nums[i];
            }
        }
        String temp = new String();
        if(low<high){
            temp += low;
            temp += "->";
            temp += high;
                    
        }
        else{
            temp += low;
        }
        ans.add(temp); 
        return ans;
    }
}