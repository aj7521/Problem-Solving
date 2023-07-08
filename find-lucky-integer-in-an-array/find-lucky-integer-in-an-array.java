class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for(int i=0; i<arr.length; i++)
        {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        for(Map.Entry<Integer, Integer> mp: map.entrySet()){
            int key = mp.getKey();
            int val = mp.getValue();
            if(key==val){
                max = Math.max(max, key);
            }
        }
        return max;
    }
}