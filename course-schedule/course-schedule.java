class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Making of indegree
        int indegree[] = new int[numCourses];
        //Making of adj
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        //Marking indegree and adj
        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v]++;
            adj.get(u).add(v);
        } 
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.poll();
            ans.add(temp);
            for(Integer i: adj.get(temp)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        if(ans.size()==numCourses){
            return true;
        }
        return false;
    }
}