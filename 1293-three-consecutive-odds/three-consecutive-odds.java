class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for(int i=1; i<=n-2; i++){
            if(arr[i]%2==1 && arr[i-1]%2==1 && arr[i+1]%2==1){
                return true;
            }
        }
        return false;
    }
}