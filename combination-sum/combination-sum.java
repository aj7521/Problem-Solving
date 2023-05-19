class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        count(n-1, target, candidates, ans, new ArrayList<>());
        return ans;
    }

    public void count(int i, int tar, int arr[], List<List<Integer>> ans, List<Integer>temp){
        if(i==-1){
            if(tar==0){
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        count(i-1, tar, arr, ans, temp);
        
        if(arr[i]<=tar){
            temp.add(arr[i]);
            count(i, tar-arr[i], arr, ans, temp);
            temp.remove(temp.size()-1);
        }
        return;
    }

}