class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //makeAdj
        int dist[] = new int[n+1];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        //djikstra
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.wt-b.wt));
        dist[0] = 0;
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int curnode = p.node;
            int curdis = p.wt;
            for(Pair temp: adj.get(curnode)){
                int node = temp.node;
                int dis = curdis + temp.wt;
                if(dist[node] > dis){
                    dist[node] = Math.min(dist[node], dis);
                    pq.add(new Pair(node, dis));
                }
            }
        }

        //checking & updating
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}

class Pair{
    int node;
    int wt;
    Pair(int n, int w){
        node = n;
        wt = w;
    }
}