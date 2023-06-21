class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int n = nums.length;
        map.put(0, 1);
        int cursum = 0;
        for(int i=0; i<n; i++){
            cursum += nums[i];
            int remove = cursum - k;
            count += map.getOrDefault(remove, 0);
            map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        }
        return count;
    }
}