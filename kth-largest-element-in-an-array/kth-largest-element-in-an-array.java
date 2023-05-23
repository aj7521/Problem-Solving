class Solution {
    PriorityQueue<Integer> q;
    int K;
    public int findKthLargest(int[] nums, int k) {
        K = k;
        q = new PriorityQueue<>();
        for(int i: nums){
            add(i);
        }
        return q.peek();
    }

    public void add(int val){
        if(q.size()<K){
            q.offer(val);
        }
        else if(q.peek()<val){
            q.poll();
            q.offer(val);
        }
    }
}