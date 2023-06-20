class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int rad = (k*2) + 1; 
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        if(n<rad){
            return ans;
        }
        if(k==0){
            return nums;
        }
        int l=0;
        int r=0;
        int p=k;
        long cursum = 0;
        //first set
        for(int i=0; i<rad; i++){
            cursum += nums[i];
            r++;
        }
        ans[p] = (int)(cursum / (long)rad);
        // System.out.println(nums[r] + " " + cursum);
        //carry-on
        while(r<n){
            p++;
            cursum += nums[r];
            cursum -= nums[l];
            l++;
            r++;
            ans[p] = (int)(cursum / (long)rad);
        }
               
        return ans;
    }
}