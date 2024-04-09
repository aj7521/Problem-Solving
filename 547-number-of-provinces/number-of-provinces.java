class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i]==false){
                count++;
                dfs(i, vis, isConnected);
            }
        }
        return count;
    }

    public void dfs(int i, boolean[] vis, int[][] isConnected){
        vis[i] = true;
        for(int it=0; it<isConnected.length; it++){
            if(isConnected[i][it]==1 && vis[it]==false){
                dfs(it, vis, isConnected);
            }
        }
        return;
    }
}