class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int count[] = new int[26];
        boolean vis[] = new boolean[26];
        for(int i=0; i<n; i++){
            count[s.charAt(i)-'a']++;
        }

        st.push(s.charAt(0)-'a');
        count[s.charAt(0)-'a']--;
        vis[s.charAt(0)-'a'] = true; 
        for(int i=1; i<n; i++){
            int cur = s.charAt(i)-'a';
            if(vis[cur]){
                count[cur]--;
                continue;
            }
            while(!st.isEmpty() && cur < st.peek() && count[st.peek()]>0){
                vis[st.pop()] = false;
            }
            vis[cur] = true;
            count[cur]--;
            st.push(cur);
        }

        char ch[] = new char[st.size()];
        int p = ch.length-1;
        while(!st.isEmpty()){
            ch[p] = (char)(st.pop()+'a');
            p--;
        }
        return new String(ch);
    }
}