class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, ans, temp, 0);
        return ans;
    }

    public void helper(int nums[], List<List<Integer>> ans, List<Integer> temp, int i)
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(nums, ans, temp, i+1);
        temp.remove(temp.size()-1);
        helper(nums, ans, temp, i+1);
    }
}