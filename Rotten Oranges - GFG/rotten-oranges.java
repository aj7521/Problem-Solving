//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
		int fresh = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 2){
					q.offer(new Pair(i, j));
				}
				else if(grid[i][j] == 1){
					fresh++;
				}
			}
		}
		if(fresh==0) return 0;
		int time = 0;
		int col[] = {0,1,0,-1};
		int row[] = {-1,0,1,0};
		while(!q.isEmpty()){
			int size = q.size();
			for(int i=0; i<size; i++){
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				for(int j=0; j<row.length; j++){
					int xa = x + row[j];
					int ya = y + col[j];
					if(xa>=0 && xa<n && ya>=0 && ya<m && grid[xa][ya]==1){
						q.offer(new Pair(xa, ya));
						grid[xa][ya] = 2;
					}
				}
			}
			time++;
		}
		// checking
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j]==1){
					return -1;
				}
			}
		}
		return time-1;
    }
}
class Pair{
	int x;
	int y;
	Pair(int i, int j){
		x = i;
		y = j;
	}
}