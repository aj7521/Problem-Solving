class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!vis[i]){
                boolean check = dfs(i, adj, vis, path);
                if(check){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int i, List<List<Integer>> adj, boolean vis[], boolean path[]){
        vis[i] = true;
        path[i] = true;
        for(Integer n: adj.get(i)){
            if(!vis[n]){
                if(dfs(n, adj, vis, path)){
                    return true;
                }
                
            }
            else if(path[n]){
                return true;
            }
        }
        path[i] = false;
        return false;
    }
}