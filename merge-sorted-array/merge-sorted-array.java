class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1, n1 = m-1, n2 = n-1;
        while(p>=0)
        {
            if(n1 < 0)
            {
                nums1[p--] = nums2[n2--];
            }
            else if(n2 < 0)
            {
                nums1[p--] = nums1[n1--];
            }
            else
            {
                if(nums1[n1] <= nums2[n2])
                {
                    nums1[p--] = nums2[n2--];
                }
                else
                {
                    nums1[p--] = nums1[n1--];
                }
            }
        }
        return;
    }
}