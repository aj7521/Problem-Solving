class Solution {
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0,1});
        map.put('D', new int[]{0,-1});
        map.put('L', new int[]{-1,0});
        map.put('R', new int[]{1,0});
        int pos[] = new int[2];
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            int cp[] = map.get(c);
            pos[0] += cp[0];
            pos[1] += cp[1];
        }
        return (pos[0]==0 && pos[1]==0);
    }
}