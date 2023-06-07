class Solution {
    public int minFlips(int a, int b, int c) {
        String ax = toBinary(a);
        String bx = toBinary(b);
        String cx = toBinary(c);
        
        int maxlen = Math.max(ax.length(), Math.max(bx.length(), cx.length()));
        int adif = maxlen-ax.length();
        int bdif = maxlen-bx.length();
        int cdif = maxlen-cx.length();
        for(int i=0; i<adif; i++){
            ax += 0;
        }
        for(int i=0; i<bdif; i++){
            bx += 0;
        }
        for(int i=0; i<cdif; i++){
            cx += 0;
        }
        System.out.println(ax + " " + bx + " "  + cx);
        int count = 0;
        for(int i=0; i<maxlen; i++){
            char cc = cx.charAt(i);
            char ac = ax.charAt(i);
            char bc = bx.charAt(i);
            if(ac=='0' && bc=='0' && cc=='1'){
                count++;
            }
            else if(ac=='0' && bc=='1' && cc=='0'){
                count++;
            }
            else if(ac=='1' && bc=='0' && cc=='0'){
                count++;
            }
            else if(ac=='1' && bc=='1' && cc=='0'){
                count += 2;
            }
        }
        return count;
    }
    public String toBinary(int decimal){ 
        String temp = "";  
        while(decimal > 0){    
            temp += decimal%2;    
            decimal = decimal/2;    
        }
        return temp;
    }    
}