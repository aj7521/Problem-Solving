class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(arr, 0, ans, list);
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }

    public void helper(int arr[], int i, Set<List<Integer>> ans, List<Integer> list)
    {
        if(i==arr.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        helper(arr, i+1, ans, list);
        list.remove(list.size()-1);
        helper(arr, i+1, ans, list);
    }
}