class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr[i] = entry.getKey();
            i++;
        }
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr.length-1, arr, map, dp);
    }
    public int helper(int i, int[] arr, TreeMap<Integer, Integer> map, int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int np = helper(i-1, arr, map, dp);
        int p = arr[i]*map.get(arr[i]);
        if(i>0 && arr[i-1]==arr[i]-1){
            p += helper(i-2, arr, map, dp);
        }
        else{
            p += helper(i-1, arr, map, dp);
        }
        return dp[i] = Math.max(p, np);
    }
}