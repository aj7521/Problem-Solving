class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0; i<points.length; i++)
	    {
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0; i<points.length-1; i++)
	    {
            for(int j=i+1; j<points.length; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));
            }
	    }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
	    boolean vis[] = new boolean[points.length];
	    pq.offer(new Pair(0,0));
	    int sum = 0;
	    while(!pq.isEmpty())
	    {
	        Pair p = pq.poll();
	        int node = p.second;
	        int wt = p.first;
	        if(vis[node]) continue;
	        vis[node] = true;
	        sum += wt;
	        for(Pair ed: adj.get(node))
	        {
	            int curwt = ed.second;
	            int curnode = ed.first;
	            if(!vis[curnode])
	            {
	                pq.offer(new Pair(curwt, curnode));
	            }
	        }
	    }
	    return sum;
    }
}
class Pair{
    int first;
    int second;
    Pair(int n, int w)
    {
        first = n;
        second = w;
    }
}