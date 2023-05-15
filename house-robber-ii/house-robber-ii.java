class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        for(int i=0; i<nums.length-1; i++)
        {
            arr1[i] = nums[i];
            System.out.print(arr1[i] + " ");
        }
        int p = 0;
        System.out.println();
        for(int i=1; i<nums.length; i++)
        {
            arr2[p] = nums[i];
            System.out.print(arr2[p] + " ");
            p++;
        }
        return Math.max(check(arr1), check(arr2));
    }

    public int check(int arr[])
    {
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1; i<arr.length; i++){
            int np = prev;
            int p = arr[i];
            if(i>1) p+=prev2;
            int cur = Math.max(np, p);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}