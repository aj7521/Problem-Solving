class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)){
            return 0;
        }
        set.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String temp = p.s;
            int val = p.val;
            if(temp.equals(endWord)){
                return val;
            }
            char ch[] = new char[temp.length()];
            for(int i=0; i<temp.length(); i++){
                ch[i] = temp.charAt(i);
            }
            for(int i=0; i<temp.length(); i++){
                for(int j=0; j<26; j++){
                    ch[i] = (char) (j+97);
                    String check = new String(ch);
                    if(!check.equals(temp) && set.contains(check)){
                        set.remove(check);
                        q.offer(new Pair(check, val+1));
                    }
                }
                ch[i] = temp.charAt(i);
            }
        }
        return 0;
    }
}
class Pair{
    String s;
    int val;
    Pair(String str, int i){
        s = str;
        val = i;
    }
}