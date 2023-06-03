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
        Set<String> set = new HashSet<>();
        boolean vis[][] = new  boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    String s = bfs(i, j, n, m, grid, vis);
                    set.add(s);
                }
            }
        }
        return set.size();
    }
    public String bfs(int i, int j, int n, int m, int grid[][], boolean vis[][]){
        vis[i][j] = true;
        String temp = "";
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        int basei = i;
        int basej = j;
        int x[] = {0,1,0,-1};
        int y[] = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            temp += r-basei;
            temp += c-basej;
            for(int k=0; k<4; k++){
                int xa = x[k] + r;
                int ya = y[k] + c;
                if(xa>=0 && xa<n && ya>=0 && ya<m && !vis[xa][ya] && grid[xa][ya]==1){
                    vis[xa][ya] = true;
                    q.offer(new Pair(xa, ya));
                }
            }
        }
        return temp;
    }
}

class Pair{
    int i;
    int j;
    Pair(int r, int c){
        i = r;
        j = c;
    }
}