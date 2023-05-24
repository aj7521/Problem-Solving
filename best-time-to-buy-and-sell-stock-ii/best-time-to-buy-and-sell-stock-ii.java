class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int b = 0, nb = 0;
        int profit = 0;
        for(int i=n-1; i>=0; i--){
            nb = Math.max(b + arr[i], nb);
            b = Math.max(nb - arr[i], b);
        }
        return b;
    }
}