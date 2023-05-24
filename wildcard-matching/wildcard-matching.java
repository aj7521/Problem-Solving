class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<=n; i++){
            dp[i][0] = false;
        }
        for(int j=1; j<=m; j++){
            boolean flag = true;
            for(int ii=1; ii<=j; ii++){
                if(p.charAt(ii-1)!='*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    boolean empty = dp[i][j-1];
                    boolean nonEmpty = dp[i-1][j];
                    dp[i][j] = empty|nonEmpty;
                }
            }
        }
        return dp[n][m];
        // return count(n, m, s, p, dp);
    }
    // public boolean count(int i, int j, String s, String p, boolean dp[][]){
    //     if(i==0 && j==0) return true;
    //     if(i>0 && j==0) return false;
    //     if(j>0 && i==0){
    //         for(int ii=1; ii<=j; ii++){
    //             if(p.charAt(ii-1)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     if(dp[i][j] != false) return dp[i][j]; 
    //     if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?'){
    //         return dp[i][j] = count(i-1, j-1, s, p, dp);
    //     }
    //     if(p.charAt(j-1)=='*'){
    //         boolean empty = count(i, j-1, s, p, dp);
    //         boolean nonEmpty = count(i-1, j, s, p, dp);
    //         return dp[i][j] = empty|nonEmpty;
    //     }
    //     return dp[i][j] = false;
    // }
}