//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<Dictionary.length; i++){
            String temp = abv(Dictionary[i]);
            if(temp.indexOf(Pattern)==0){
                ans.add(Dictionary[i]);
            }
        }
        if(ans.size()==0){
            ans.add("-1");
        }
        else{
            Collections.sort(ans);
        }
        return ans;
    }
    
    public String abv(String s){
        String temp = "";
        for(int i=0; i<s.length(); i++){
            if((int)s.charAt(i) >=65 && (int)s.charAt(i) <=90){
                temp += s.charAt(i);
            }
        }
        return temp;
    }
}