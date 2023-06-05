class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int n = intervals.length;
        for(int i[]: intervals){
            System.out.println(i[0] + " " + i[1]);
        }
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<n; i++){
            if(intervals[i][0] < end){
                end = Math.min(end, intervals[i][1]);
                count++;
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return count;
    }
}