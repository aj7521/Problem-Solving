//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        boolean path[] = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
            {
                if(dfs(i, vis, path, adj))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, boolean vis[], boolean path[], ArrayList<ArrayList<Integer>> adj)
    {
        vis[i] = true;
        path[i] = true;
        for(Integer j: adj.get(i))
        {
            if(!vis[j])
            {
                if(dfs(j, vis, path, adj)) return true;
            }
            else if(path[j])
            {
                return true;
            }
        }
        path[i] = false;
        return false;
    }
}