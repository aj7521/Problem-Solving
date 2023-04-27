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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean [n][m];
        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                ArrayList<Pair> temp = new ArrayList<>();
                if(!vis[i][j] && grid[i][j]==1)
                {
                    dfs(i, j, vis, grid, temp);
                    addingSet(set, temp);
                }
            }
        }
        // for(int i=0; i<n; i++)
        // {
        //     for(int j=0; j<m; j++)
        //     {
        //         System.out.print(vis[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // for(ArrayList<Pair> al: ans)
        // {
        //     for(Pair p: al)
        //     {
        //         System.out.println(p.r + " " + p.c);
        //     }
        //     System.out.println();
        // }
        return set.size();
    }
    public void dfs(int r, int c, boolean vis[][], int arr[][], ArrayList<Pair> temp)
    {
        vis[r][c] = true;
        temp.add(new Pair(r,c));
        int n = arr.length;
        int m = arr[0].length;
        int x[] = {0,1,0,-1};
        int y[] = {-1,0,1,0};
        for(int i=0; i<4; i++)
        {
            int rx = r + x[i];
            int cx = c + y[i];
            if(rx>=0 && rx<n && cx>=0 && cx<m && !vis[rx][cx] && arr[rx][cx]==1)
            {
                dfs(rx, cx, vis, arr, temp);
            }
        }
    }
    public void addingSet(Set<String> set, ArrayList<Pair> temp)
    {
        String cur = new String();
        int baseRow = temp.get(0).r;
        int baseCol = temp.get(0).c;
        for(Pair p: temp)
        {
            int row = p.r - baseRow;
            int col = p.c - baseCol;
            cur += row;
            cur += col;
        }
        set.add(cur);
    }
}
class Pair{
    int r; int c;
    Pair(int rx, int cx)
    {
        r = rx;
        c = cx;
    }
}
