// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class Node{
    Node next;
    int val;
    Node(int val){
        this.val = val;
    }
}
class PeekingIterator implements Iterator<Integer> {
    Node head = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        Node cur = null;
        while(iterator.hasNext()){
            if(head==null){
                head = new Node(iterator.next());
                cur = head;
            }
            else{
                Node temp = new Node(iterator.next());
                cur.next = temp;
                cur = temp;
            }
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return head.val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer v = head.val;
        head = head.next;
        return v;
	}
	
	@Override
	public boolean hasNext() {
        return head!=null;
	}
}