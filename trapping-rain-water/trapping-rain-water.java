class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        //prefix
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            prefix[i] = max;
        }

        //suffix
        max = 0;
        for(int i=n-1; i>=0; i--){
            max = Math.max(max, arr[i]);
            suffix[i] = max;
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            int min = Math.min(prefix[i], suffix[i]);
            int val = min - arr[i];
            if(val>0){
                sum += val;
            }
        }
        return sum;
    }
}