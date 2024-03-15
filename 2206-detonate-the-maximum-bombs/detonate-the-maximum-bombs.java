class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = getAdjList(bombs, n);
        int maxCount = 0;
        for(int i=0; i<n; i++){
            boolean[] vis = new boolean[n];
            int count = dfs(adj, vis, i, n);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public int dfs(List<List<Integer>> adj, boolean[] vis, int i, int n){
        int count = 1;
        vis[i] = true;
        for(Integer it: adj.get(i)){
            if(!vis[it]){
                count += dfs(adj, vis, it, n);
            }
        }
        return count;
    }

    public List<List<Integer>> getAdjList(int[][] bombs, int n){
        List<List<Integer>> adj = new ArrayList<>();
        boolean[][] valid = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    valid[i][j] = true;
                }
                else{
                    if(Math.sqrt(Math.pow(Math.abs(bombs[i][0]-bombs[j][0]),2) + Math.pow(Math.abs(bombs[i][1]-bombs[j][1]),2)) <= bombs[i][2]){
                        valid[i][j] = true;
                    }
                    else{
                        valid[i][j] = false;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(valid[i][j] == true){
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}