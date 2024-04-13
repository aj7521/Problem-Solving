class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = makeAdj(n, dislikes);
        int arr[] = new int[n+1];
        Arrays.fill(arr, -1);
        for(int i=0; i<n; i++){
            if(arr[i]==-1){
                if(dfs(0, i, adj, arr)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int c, int i, List<List<Integer>> adj, int[] arr){
        arr[i] = c;
        for(Integer it: adj.get(i)){
            if(arr[it]==-1){
                if(dfs(1-c, it, adj, arr)==false){
                    return false;
                }
            }
            else{
                if(arr[it]==arr[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<Integer>> makeAdj(int n, int[][] dis){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<dis.length; i++){
            int u = dis[i][0];
            int v = dis[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}