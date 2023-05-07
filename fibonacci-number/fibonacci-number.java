class Solution {
    public int fib(int n) {
        int prev = 1;
        int prev2 = 0;
        if(n==0) return prev2;
        for(int i=2; i<=n; i++)
        {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}