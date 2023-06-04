class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char cur = s.charAt(i);
            System.out.println(cur);
            if(cur=='(' || cur=='{' || cur=='['){
                st.push(cur);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if(!validate(st.peek(), cur)){
                    return false;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }

    public boolean validate(char open, char close){
        return ((open=='(' && close==')')||(open=='{' && close=='}')||(open=='[' && close==']'));
    }
}