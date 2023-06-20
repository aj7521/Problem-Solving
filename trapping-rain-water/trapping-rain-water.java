class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int l = 0, r = n-1;
        int maxl = arr[0];
        int maxr = arr[n-1];
        int sum = 0;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(arr[l]>maxl){
                    maxl = arr[l];
                }
                if(maxl - arr[l] > 0){
                    sum += maxl - arr[l];
                }
                
                l++;
            }
            else{
                if(arr[r]>maxr){
                    maxr = arr[r];
                }
                if(maxr - arr[r] > 0){
                    sum += maxr - arr[r];
                }
                
                r--;
            }

        }
        return sum;
    }
}