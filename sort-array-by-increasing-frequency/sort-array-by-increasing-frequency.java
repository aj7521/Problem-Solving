class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.freq==b.freq?b.val-a.val:a.freq-b.freq);
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> mp: map.entrySet()){
            pq.offer(new Pair(mp.getValue(), mp.getKey()));
        }
        int ans[] = new int[nums.length];
        int p = 0;
        while(!pq.isEmpty()){
            Pair pa = pq.poll();
            int val = pa.val;
            int freq = pa.freq;
            for(int i=0; i<freq; i++){
                ans[p++] = val;
            }
        }
        return ans;
    }
}
class Pair{
    int freq;
    int val;
    Pair(int _freq, int _val){
        freq = _freq;
        val = _val;
    }
}