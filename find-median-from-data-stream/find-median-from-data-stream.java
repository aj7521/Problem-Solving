class MedianFinder {
    //small -> MAX_HEAP    ...     large => MIN_HEAP
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean elementsEven;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        elementsEven = true;
    }
    
    public void addNum(int num) {
        if(elementsEven==true){
            large.offer(num);
            small.offer(large.poll());
        }
        else{
            small.offer(num);
            large.offer(small.poll());
        }
        elementsEven = !elementsEven;
    }
    
    public double findMedian() {
        if(elementsEven==true){
            return (small.peek() + large.peek()) / 2.0;
        }
        else{
            return (small.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */