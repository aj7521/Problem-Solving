class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int n = numCourses;
        int inorder[] = new int[n];
        int ans[] = new int[n];
        //makeAdj
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<pre.length; i++){
            adj.get(pre[i][0]).add(pre[i][1]);
            inorder[pre[i][1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(inorder[i]==0){
                q.offer(i);
                st.push(i);
            }
        }
        
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i: adj.get(temp)){
                inorder[i]--;
                if(inorder[i]==0){
                    q.offer(i);
                    st.push(i);
                }
            }
        }
        if(st.size()==n){
            for(int i=0; i<n; i++){
                ans[i] = st.pop();
            }
            return ans;
        }
        return new int[]{};
    }
}