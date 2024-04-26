class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = getList(n, edges);
        Set<Integer> set = getRestricted(restricted);
        boolean[] vis = new boolean[n];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        if(set.contains(0)) return 0;
        q.offer(0);
        count++;
        vis[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int val = q.poll();
                for(Integer it: adj.get(val)){
                    if(vis[it]!=true && !set.contains(it)){
                        q.offer(it);
                        vis[it] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public Set<Integer> getRestricted(int[] restricted){
        Set<Integer> set = new HashSet<>();
        for(Integer it: restricted){
            set.add(it);
        }
        return set;
    }

    public List<List<Integer>> getList(int n, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return adj;
    }
}