class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s: wordList)
        {
            set.add(s);
        }
        set.remove(beginWord);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        int max = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String str = p.s;
            char ch [] = new char[str.length()];
            for(int i=0; i<ch.length; i++)
            {
                ch[i] = str.charAt(i);
            }
            int c = p.c;
            if(str.equals(endWord)) return c;
            for(int i=0; i<ch.length; i++)
            {
                for(int j=0; j<26; j++)
                {
                    ch[i] = (char)(97+j);
                    String check = new String(ch);
                    
                    if(!check.equals(str) && set.contains(check))
                    {
                        set.remove(check);
                        q.offer(new Pair(check, c+1));
                    }
                }
                ch[i] = str.charAt(i);
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int c;
    Pair(String str, int cnt)
    {
        s = str;
        c = cnt;
    }
}