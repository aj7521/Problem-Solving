class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        int pro = 0;
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                pro++;
                dfs(i, vis, adj);
            }
        }
        return pro;
    }

    public void dfs(int i, boolean vis[], List<List<Integer>> adj){
        vis[i] = true;
        for(int j: adj.get(i)){
            if(!vis[j]){
                dfs(j, vis, adj);
            }
        }
        return;
    }
}