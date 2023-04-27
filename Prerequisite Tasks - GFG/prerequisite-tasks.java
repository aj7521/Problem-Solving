//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n, int[][] prerequisites)
    {
        // Your Code goes here
        List<List<Integer>> adj = makeAdj(n, prerequisites);
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                if(dfs(i, vis, path, adj))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, boolean vis[], boolean path[], List<List<Integer>> adj)
    {
        vis[node] = true;
        path[node] = true;
        for(Integer i: adj.get(node))
        {
            if(!vis[i])
            {
                if(dfs(i, vis, path, adj))
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
        return false;
    }
    public List<List<Integer>> makeAdj(int n, int pre[][])
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<pre.length; i++)
        {
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        return adj;
    }
}