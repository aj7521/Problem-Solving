class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maj = nums.length / 3;
        for(Map.Entry<Integer, Integer> mp: map.entrySet()){
            int key = mp.getKey();
            int val = mp.getValue();
            if(val > maj){
                ans.add(key);
            }
        }
        return ans;
    }
}