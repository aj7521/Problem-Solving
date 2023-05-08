class Solution {
    public double average(int[] salary) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;

        for(int i=0; i<salary.length; i++)
        {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            sum += salary[i];
        }
        double finalsum = sum - max - min;
        int totalnum = salary.length-2;
        return finalsum/totalnum;
    }
}