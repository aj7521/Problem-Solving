class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<Integer>();
        for(int i: nums){
            add(i);
        }
    }
    
    public int add(int val) {
        System.out.print(val + " ");
        if(pq.size()<K){
            pq.add(val);
        }
        else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */