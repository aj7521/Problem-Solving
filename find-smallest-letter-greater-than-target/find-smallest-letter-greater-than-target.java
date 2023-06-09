class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int ch[] = new int[26];
        char c = find(ch, letters, target);
        if(c=='0'){
            return letters[0];
        }
        return c;
    }

    public char find(int ch[], char[] letters, char target){
        for(int i=0; i<letters.length; i++){
            ch[(int)(letters[i])-97]++;
        }
        int tar = (int)(target)-97;
        for(int i=0; i<ch.length; i++){
            if(i>tar && ch[i]>0){
                return (char)(i+97);
            }
        }
        return '0';
    }
}