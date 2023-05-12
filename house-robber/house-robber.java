class Solution {
    public int rob(int[] nums) {
        return check(nums);
    }

    public int check(int arr[])
    {
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1; i<arr.length; i++)
        {
            int take = arr[i];
            if(i>1) take+=prev2;
            int nontake = 0 + prev;

            int curi = Math.max(take, nontake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    
}