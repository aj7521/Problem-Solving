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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int Solve(int n, int[][] connections) {
        int par[] = new int[n];
        int size[] = new int[n];
        for(int i=0; i<n; i++)
        {
            par[i] = i;
            size[i] = 1;
        }
        int extraConnections = 0;
        int connectionsNeeded = 0;
        for(int i=0; i<connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            if(findUpar(u,par) != findUpar(v,par))
            {
                union(u,v,par,size);
            }
            else
            {
                extraConnections++;
            }
        }
        for(int i=0; i<n; i++)
        {
            if(par[i] == i)
            {
                connectionsNeeded++;
            }
        }
        if(extraConnections >= connectionsNeeded-1)
        {
            return connectionsNeeded-1;
        }
        return -1;
    }

    public int findUpar(int node, int par[])
    {
        if(node==par[node]) return node;
        return par[node] = findUpar(par[node], par);
    }

    public void union(int pu, int pv, int par[], int size[])
    {
        int u = findUpar(pu,par);
        int v = findUpar(pv,par);
        if(u==v) return;
        if(size[u] < size[v])
        {
            par[u] = v;
            size[v] = size[v] + size[u];
        }
        else
        {
            par[v] = u;
            size[u] = size[v] + size[u];
        }
    }
}