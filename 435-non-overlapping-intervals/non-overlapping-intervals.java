class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int[] pair: intervals){
            pq.add(pair);
        }
        int[] pair = pq.poll();
        int count = 1;
        int freeTime = pair[1];
        while(!pq.isEmpty()){
            pair = pq.poll();
            if(pair[0] >= freeTime){
                count++;
                freeTime = pair[1];
            }
        }
        return intervals.length-count;
    }
}