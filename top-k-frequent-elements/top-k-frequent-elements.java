class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans [] = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->(b.count-a.count));
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if(hm.containsKey(nums[i]))
            {
                int n = hm.get(nums[i]);
                hm.put(nums[i], n+1);
            }
            else
            {
                hm.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> map: hm.entrySet())
        {
            int val = map.getKey();
            int count = map.getValue();
            Pair p = new Pair(val, count);
            pq.add(p);
        }
        int p = 0;
        while(p<k)
        {
            int v = pq.poll().val;
            ans[p] = v;
            p++;
        }
        return ans;
    }
}

class Pair{
    int val;
    int count;
    Pair(int v, int c)
    {
        val = v;
        count = c;
    }
}