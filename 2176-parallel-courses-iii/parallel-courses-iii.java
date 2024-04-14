class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        n = n+1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int inorder[] = new int[n+1];
        for(int i=0; i<relations.length; i++){
            adj.get(relations[i][0]).add(relations[i][1]);
            inorder[relations[i][1]]++;
        }
        int maxTime = 0;
        int recTime[] = new int[n];
        Arrays.fill(recTime, -1);
        // for(int i=1; i<n; i++){
        //     System.out.print(inorder[i] + " ");
        // }
        for(int i=1; i<n; i++){
            int t = dfs(i, adj, recTime, time);
            maxTime = Math.max(maxTime, t);
        }
        return maxTime;
    }

    public int dfs(int i, List<List<Integer>> adj, int[] recTime, int[] time){
        int max = 0;
        for(Integer it: adj.get(i)){
            if(recTime[it]==-1){
                max = Math.max(max, dfs(it, adj, recTime, time));
            }
            else{
                max = Math.max(max, recTime[it]);
            }
        }
        return recTime[i] = time[i-1] + max;
    }
}