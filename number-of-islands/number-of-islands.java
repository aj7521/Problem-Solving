class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    bfs(i, j, n, m, grid, vis);
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, int n, int m, char grid[][], boolean vis[][]){
        vis[i][j] = true;
        int x[] = {-1,0,1,0};
        int y[] = {0,-1,0,1};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int k=0; k<4; k++){
                int xa = x[k] + r;
                int ya = y[k] + c;
                if(xa>=0 && xa<n && ya>=0 && ya<m && !vis[xa][ya] && grid[xa][ya]=='1'){
                    vis[xa][ya] = true;
                    q.offer(new Pair(xa, ya));
                }
            }
        }
        return;
    }
}

class Pair{
    int r;
    int c;
    Pair(int ra, int ca){
        r = ra;
        c = ca;
    }
}