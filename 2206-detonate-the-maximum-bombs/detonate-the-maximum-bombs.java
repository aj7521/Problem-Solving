class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = makeAdjList(bombs);
        System.out.println(adj);
        int max = 0;
        for(int i=0; i<n; i++){
            boolean vis[] = new boolean[n];
            int count = dfs(i, bombs, adj, vis);
            max = Math.max(max, count);
        }
        return max;
    }

    public int dfs(int i, int[][] bombs, List<List<Integer>> adj, boolean vis[]){
        vis[i] = true;
        int count = 1;
        for(Integer it: adj.get(i)){
            if(vis[it]!=true){
                count += dfs(it, bombs, adj, vis);
            }
        }
        return count;
    }

    public List<List<Integer>> makeAdjList(int[][] bombs){
        List<List<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r = bombs[i][2];
            for(int j=0; j<n; j++){
                if(i==j) continue;
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                if(Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2)) <= r){
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}