class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.dif==a.dif?b.val-a.val:b.dif-a.dif);

        for(int i=0; i<n; i++){
            int curdif = Math.abs(arr[i] - x);
            pq.offer(new Pair(arr[i], curdif));
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(pq.size()>0){
            ans.add(pq.poll().val);
        }
        Collections.sort(ans);
        return ans;
    }
}

class Pair{
    int val;
    int dif;
    Pair(int v, int d){
        val = v;
        dif = d;
    }
}