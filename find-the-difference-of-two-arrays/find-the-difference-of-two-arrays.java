class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0; i<nums1.length; i++)
        {
            set1.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++)
        {
            set2.add(nums2[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set11 = new HashSet<>();
        HashSet<Integer> set21 = new HashSet<>();
        for(int i=0; i<nums1.length; i++)
        {
            if(!set2.contains(nums1[i]))
            {
                set11.add(nums1[i]);
            }
        }
        for(int i=0; i<nums2.length; i++)
        {
            if(!set1.contains(nums2[i]))
            {
                set21.add(nums2[i]);
            }
        }
        List<Integer> temp1 = new ArrayList<>(set11);
        List<Integer> temp2 = new ArrayList<>(set21);
        ans.add(temp1);
        ans.add(temp2);
        return ans;
    }
}