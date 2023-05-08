class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = Integer.MIN_VALUE;
        int i=0;
        int j=0;
        int curCount = 0;
        while(j!=k)
        {
            if(isVowel(s.charAt(j)))
            {
                curCount++;
            }
            j++;
        }
        if(curCount > 0)
        {
            maxCount = curCount;
        }
        while(j<s.length())
        {
            if(isVowel(s.charAt(j)))
            {
                curCount++;
            }
            if(isVowel(s.charAt(i)))
            {
                curCount--;
            }
            maxCount = Math.max(maxCount, curCount);
            i++;
            j++;
        } 
        // System.out.println(s.charAt(i) + " " + s.charAt(j));
        return maxCount;        
    }

    public boolean isVowel(char c)
    {
        if(c=='a' || c=='e' || c=='o' || c=='u' || c=='i')
        {
            return true;
        } 
        return false;
    }
}