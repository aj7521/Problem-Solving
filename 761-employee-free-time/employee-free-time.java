/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flattenedIntervals = new ArrayList<>();
        
        for (List<Interval> intervals : schedule) {
            flattenedIntervals.addAll(intervals);
        }
        
        flattenedIntervals.sort((a, b) -> Integer.compare(a.start, b.start));
        
        List<Interval> freeTimeIntervals = new ArrayList<>();
        int prevEnd = flattenedIntervals.get(0).end;
        
        for (int i = 1; i < flattenedIntervals.size(); i++) {
            Interval curr = flattenedIntervals.get(i);

             if (curr.start > prevEnd) {
                freeTimeIntervals.add(new Interval(prevEnd, curr.start));
            }
            
            prevEnd = Math.max(prevEnd, curr.end);
        }
        
        return freeTimeIntervals;
    }
}