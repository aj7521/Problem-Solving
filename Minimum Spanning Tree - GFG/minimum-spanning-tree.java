//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0; i<V; i++)
	    {
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0; i<edges.length; i++)
	    {
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
	    boolean vis[] = new boolean[V];
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