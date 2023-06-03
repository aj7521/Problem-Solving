class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        Queue<Integer> q = new LinkedList<>();
        for(int j=0; j<n; j++){
            if(vis[j]==-1){
                q.offer(j);
                while(!q.isEmpty()){
                    int temp = q.poll();
                    for(int i: graph[temp]){
                        if(vis[i]==-1){
                            q.offer(i);
                            vis[i] = 1-vis[temp];
                        }
                        else if(vis[i]==vis[temp]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}