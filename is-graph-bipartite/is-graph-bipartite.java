class Solution {
    public ArrayList<ArrayList<Integer>> makeAdj(int arr[][])
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<arr.length; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<arr[i].length; j++)
            {
                temp.add(arr[i][j]);
            }
            adj.add(temp);
        }
        return adj;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = makeAdj(graph);
        int color[] = new int [graph.length];
        for(int i=0; i<color.length; i++)
        {
            color[i] = -1;
        }
        for(int i=0; i<graph.length; i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(i, 0, adj, color))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int start, int col, ArrayList<ArrayList<Integer>> adj, int color[])
    {
        color[start] = col;
        for(Integer i: adj.get(start))
        {
            if(color[i]==-1)
            {
                if(!dfs(i, 1-col, adj, color))
                {
                    return false;
                }
            }
            else if(color[i]==color[start])
            {
                return false;
            }
        }
        return true;
    }

    public boolean bfsOfGraph(int start, int V, ArrayList<ArrayList<Integer>> adj, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty())
        {
            Integer x = q.poll();
            for(Integer i: adj.get(x))
            {
                if(color[i]==-1)
                {
                    q.offer(i);
                    color[i] = 1-color[x];
                }
                else if(color[i] == color[x])
                {
                    return false;
                }
            }
        }
        return true;
    }
}