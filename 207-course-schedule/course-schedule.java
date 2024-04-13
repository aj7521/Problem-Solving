class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] inorder = new int[n];
        List<List<Integer>> adj = makeAdj(n, inorder, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inorder[i]==0){
                q.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Integer it = q.poll();
                list.add(it);
                for(Integer j: adj.get(it)){
                    inorder[j]--;
                    if(inorder[j]==0){
                        q.offer(j);
                    }
                }
            }
        }
        return (list.size()==n);
    }

    public List<List<Integer>> makeAdj(int n, int[] inorder, int[][] dis){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<dis.length; i++){
            int u = dis[i][0];
            int v = dis[i][1];
            adj.get(v).add(u);
            inorder[u]++;
        }
        return adj;
    }
}