class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //makingofADJ
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        //dist[]
        int dist[] = new int[n];
        for(int i=0; i<n; i++)
        {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        //pq
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, src, k));
        while(!pq.isEmpty())
        {
            Tuple t = pq.poll();
            int dis = t.d;
            int node = t.n;
            int sLeft = t.k;
            if(sLeft==-1)
            {
                continue;
            }
            for(Pair p: adj.get(node))
            {
                int curnode = p.node;
                int curdis = p.dis;
                if(sLeft==0)
                {
                    if(curnode==dst && dist[curnode] > curdis + dis)
                    {
                        dist[curnode] = dis+curdis;
                        pq.offer(new Tuple(dis+curdis, curnode, sLeft-1));
                    }
                }
                else
                {
                    if(dist[curnode] > curdis + dis)
                    {
                        dist[curnode] = dis+curdis;
                        pq.offer(new Tuple(dis+curdis, curnode, sLeft-1));
                    }
                }
            }
        }
        // for(int i=0; i<n; i++)
        // {
        //     System.out.print(dist[i] + " ");
        // }
        if(dist[dst]!=(int)(1e9))
        {
            return dist[dst];
        }
        return -1;
    }
}
class Pair{
    int node;
    int dis;
    Pair(int i, int j)
    {
        node = i;
        dis = j;
    }
}
class Tuple{
    int d;
    int n;
    int k;
    Tuple(int dis, int node, int ks)
    {
        d = dis;
        n = node;
        k = ks;
    }
}