//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adjm, int V) {
        // adjm to adj
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<V; j++)
            {
                if(adjm.get(i).get(j)==1 && i!=j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
            {
                count++;
                dfs(i, vis, adj);
            }
            
        }
        return count;
    }
    static void dfs(int i, boolean vis[], ArrayList<ArrayList<Integer>> adj)
    {
        vis[i] = true;
        for(Integer j: adj.get(i))
        {
            if(!vis[j])
            {
                dfs(j, vis, adj);
            }
        }
    }
};