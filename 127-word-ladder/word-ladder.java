class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                String curWord = p.word;
                int curLen = p.count;
                if(curWord.equals(endWord)) return curLen;
                if(set.remove(curWord));
                char[] word = curWord.toCharArray();
                for(int j=0; j<word.length; j++){
                    char orgLetter = word[j];
                    for(int s=0; s<26; s++){
                        char c = (char)(s+'a');
                        word[j] = c;
                        String newWord = new String(word);
                        if(set.contains(newWord)){
                            q.offer(new Pair(newWord, curLen+1));
                        }
                    }
                    word[j] = orgLetter;
                }
            }
        }
        return 0;
    }
}

class Pair{
    String word;
    int count;
    Pair(String w, int c){
        word = w;
        count = c;
    }
}