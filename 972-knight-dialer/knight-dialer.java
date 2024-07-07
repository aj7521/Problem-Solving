class Solution {
    int mod = 1000000000 + 7;
    int[][] memo;
    int[][] position = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        memo=new int[n+1][10];
        for(int[] d: memo){
            Arrays.fill(d, -1);
        }
        int ans=0;
        for(int i=0; i<10 ; i++){
            ans = (ans + dfs(n-1,i))%mod;
        }
        return ans;
    }
    public int dfs(int n,int pos){
        if(n==0){
            return 1;
        }
        if(memo[n][pos]!=-1){
            return memo[n][pos];
        }
        int count=0;
        for(int i=0; i<position[pos].length; i++){
            count=(count+dfs(n-1,position[pos][i]))%mod;
        }
        return memo[n][pos] = count;
    }
}