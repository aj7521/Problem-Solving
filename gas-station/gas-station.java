class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int realCost[] = new int[n];
        int totalSum = 0;
        int surplus = 0;
        int start = 0;
        for(int i=0; i<n; i++){
            realCost[i] = gas[i] - cost[i];
            totalSum += realCost[i];
            surplus += realCost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (totalSum < 0) ? -1 : start;
    }
}