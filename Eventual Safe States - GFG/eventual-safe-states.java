//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        boolean vis[] = new boolean[V];
        boolean path[] = new boolean[V];
        boolean check[] = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
            {
                dfs(i, vis, path, adj, check);
            }
        }
        for(int i=0; i<V; i++)
        {
            if(check[i])
            {
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int node, boolean vis[], boolean path[], List<List<Integer>> adj, boolean check[])
    {
        vis[node] = true;
        path[node] = true;
        check[node] = false;
        for(Integer i: adj.get(node))
        {
            if(!vis[i])
            {
                if(dfs(i, vis, path, adj, check))
                {
                    return true;
                }
            }
            else if(path[i])
            {
                return true;
            }
        }
        path[node] = false;
        check[node] = true;
        return false;
    }
}