class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int carr[] = new int[n];
        for(int i=0; i<n; i++){
            carr[i] = 1;
        }

        for(int i=0; i<edges.size(); i++){
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            carr[y] += 1;
        }
        for(int i=0; i<n; i++){
            System.out.print(carr[i] + " ");
        }
        for(int i=0; i<n; i++){
            if(carr[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}