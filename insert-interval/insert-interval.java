class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int arr[][] = new int[n+1][2];
        for(int i=0; i<n; i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[n][0] = newInterval[0];
        arr[n][1] = newInterval[1];
        Arrays.sort(arr, (a,b)->(a[0]-b[0]));
        int st = arr[0][0], en = arr[0][1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            List<Integer> temp = new ArrayList<>();
            if(arr[i][0] <= en){
                en = Math.max(en, arr[i][1]);
            }
            else{
                temp.add(st);
                temp.add(en);
                ans.add(temp);
                st = arr[i][0];
                en = arr[i][1];
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(st);
        temp.add(en);
        ans.add(temp);
        int size = ans.size();
        int res[][] = new int[size][2];
        for(int i=0; i<size; i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
}