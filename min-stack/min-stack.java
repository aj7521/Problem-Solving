class MinStack {
    Stack<Integer> store;
    Stack<Integer> min;
    public MinStack() {
        store = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        store.push(val);
        if(!min.isEmpty() && min.peek() < store.peek()){
            min.push(min.peek());
            return;
        }
        min.push(val);
    }
    
    public void pop() {
        store.pop();
        min.pop();
    }
    
    public int top() {
        return store.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */