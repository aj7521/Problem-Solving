//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // making of adj
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //topoSort
        int dist[] = new int[n];
        int max = (int)(1e9);
        for(int i=0; i<n; i++) dist[i] = max;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0));
        dist[src] = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int node = p.val;
            int curdis = p.dis;
            for(Integer x: adj.get(node))
            {
                if(dist[x] > curdis + 1)
                {
                    dist[x] = curdis + 1;
                    q.offer(new Pair(x, curdis+1));
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            if(dist[i]==max)
            {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

class Pair{
    int val;
    int dis;
    Pair(int v, int d)
    {
        val = v;
        dis = d;
    }
}