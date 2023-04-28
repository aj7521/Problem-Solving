//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //topoSort with P-Queue having Pair as {dist, node}
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dis-b.dis);
        int dist[] = new int[V];
        for(int i=0; i<V; i++)
        {
            dist[i] = (int)(1e9);
        }
        dist[S] = 0;
        pq.offer(new Pair(0,S));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int dis = p.dis;
            int node = p.node;
            for(ArrayList<Integer> al: adj.get(node))
            {
                int curnode = al.get(0);
                int curdis = al.get(1);
                if(dist[curnode] >= dis + curdis)
                {
                    dist[curnode] = dis + curdis;
                    pq.offer(new Pair(dis+curdis, curnode));
                }
            }
        }
        return dist;
    }
}

class Pair{
    int dis;
    int node;
    Pair(int d, int n)
    {
        dis = d;
        node = n;
    }
}

