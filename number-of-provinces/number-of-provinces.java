class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
                
            }
        }
        boolean vis[] = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                ans++;
                dfs(i, adj, vis);
            }
        }
        return ans;
    }

    public void dfs(int i, List<List<Integer>> adj, boolean vis[]){
        vis[i] = true;
        for(Integer ele: adj.get(i)){
            if(!vis[ele]){
                dfs(ele, adj, vis);
            }
        }
        return;
    }
}