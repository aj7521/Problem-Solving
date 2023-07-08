class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int vis[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        vis[source] = 1;
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(source);
        while(!pq.isEmpty()){
            Integer x = pq.poll();
            for(int i: adj.get(x)){
                if(vis[i]==0){
                    vis[i] = 1;
                    pq.offer(i);
                }
            }
        }
        if(vis[destination]==0){
            return false;
        }
        return true;
    }
}