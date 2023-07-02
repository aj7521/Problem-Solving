class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for (int i=0; i<nums.length-2; i++) {
            if (i==0 || (i>0 && nums[i]!=nums[i-1])){
                int vi = nums[i];
                int j = i+1;
                int k = nums.length-1;
                while(j<k){
                    int vj = nums[j];
                    int vk = nums[k];
                    int cursum = vi + vj + vk;
                    if(cursum==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(vi);
                        temp.add(vj);
                        temp.add(vk);
                        ans.add(temp);
                        while(j<k && nums[j]==nums[j+1]) j++;
                        while(j<k && nums[k]==nums[k-1]) k--;
                        j++;
                        k--;
                    }
                    else if(cursum < 0){
                        j++;
                    }
                    else if(cursum > 0){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}