//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] intervals)
    {
        // Code here // Code here
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=0; i<intervals.length; i++)
        {
            if(intervals[i][0] <= end)
            {
                end = Math.max(end, intervals[i][1]);
            }
            else
            {
                List<Integer> al = new ArrayList<>();
                al.add(start);
                al.add(end);
                ans.add(al);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        List<Integer> al2 = new ArrayList<>();
        al2.add(start);
        al2.add(end);
        ans.add(al2);
        int res[][] = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++)
        {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
}