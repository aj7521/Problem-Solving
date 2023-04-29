class Solution {
    public int countPaths(int n, int[][] roads) {
        //makeAdj
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int j=0; j<roads.length; j++)
        {
            adj.get(roads[j][0]).add(new Pair(roads[j][1],roads[j][2]));
            adj.get(roads[j][1]).add(new Pair(roads[j][0],roads[j][2]));
        }
        //dist[] & ways[]
        int dist[] = new int[n];
        int ways[] = new int[n];
        for(int i=0; i<n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        //mod
        int mod = 1000000000+7;
        //PQ
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
        pq.offer(new Pair(0,0));
        //loop-lapeta
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int dis = p.first;
            int node = p.second;
            for(Pair it: adj.get(node))
            {
                int curnode = it.first;
                int curdis = it.second;
                //first time
                if(dist[curnode] > curdis + dis)
                {
                    dist[curnode] = curdis + dis;
                    pq.offer(new Pair(curdis + dis, curnode));
                    ways[curnode] = ways[node];
                }
                else if(dist[curnode] == curdis + dis)
                {
                    ways[curnode] = (ways[curnode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}
class Pair{
    int first;
    int second;
    Pair(int f, int s)
    {
        first = f;
        second = s;
    }
}