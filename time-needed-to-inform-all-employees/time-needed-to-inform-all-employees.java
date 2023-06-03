class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            if(manager[i]==-1) continue;
            adj.get(manager[i]).add(new Pair(i, informTime[i]));
        }
        // for(int i=0; i<n; i++){
        //     for(Pair p: adj.get(i)){
        //         System.out.println(p.node + " " + p.time);
        //     }
        // }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(headID, informTime[headID]));
        int min = 0;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int curnode = temp.node;
            int curtime = temp.time;
            for(Pair o: adj.get(curnode)){
                int node = o.node;
                int time = o.time;
                int newtime = time + curtime;
                min = Math.max(min, newtime);
                q.offer(new Pair(node, time+curtime));
            }
        }
        return min;
    }
}

class Pair{
    int node;
    int time;
    Pair(int n, int t){
        node = n;
        time = t;
    }
}