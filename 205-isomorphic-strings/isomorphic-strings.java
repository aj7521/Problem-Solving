class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.containsKey(sc) && map.get(sc)==tc){
                continue;
            }
            if((map.containsKey(sc) && map.get(sc)!=tc)||(set.contains(tc))){
                return false;
            }
            else{
                map.putIfAbsent(sc, tc);
                set.add(tc);
                continue;
            }
        }
        return true;
    }
}