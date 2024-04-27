class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] q) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<pre.length; i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<q.length; i++){
            boolean[] vis = new boolean[n];
            int u = q[i][0];
            int v = q[i][1];
            if(dfs(u, v, vis, adj)){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }

    public boolean dfs(int u, int v, boolean[] vis, List<List<Integer>> adj){
        if(u==v) return true;
        vis[u] = true;
        for(Integer it: adj.get(u)){
            if(!vis[it] && dfs(it, v, vis, adj)){
                return true;
            }
        }
        return false;
    }
}