class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = Arrays.asList(1);
        ans.add(first);
        if(numRows==1) return ans;
        List<Integer> second = Arrays.asList(1,1);
        ans.add(second);
        if(numRows==2) return ans;
        int row = 2;
        while(row < numRows){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int i=1; i<row; i++){
                temp.add(ans.get(row-1).get(i-1) + ans.get(row-1).get(i));
            }
            temp.add(1);
            row++;
            ans.add(temp);
        }
        return ans;
    }
}