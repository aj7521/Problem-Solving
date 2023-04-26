//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                q.offer(new Pair(i, -1));
                
                while(!q.isEmpty())
                {
                    Pair p = q.poll();
                    int val = p.val;
                    int par = p.par;
                    for(Integer x: adj.get(val))
                    {
                        if(!vis[x])
                        {
                            vis[x] = true;
                            q.offer(new Pair(x, val));
                        }
                        else if(x!=par)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    class Pair{
        int val;
        int par;
        Pair(int v, int p)
        {
            val = v;
            par = p;
        }
    }
    
}