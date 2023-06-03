//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        int n = K;
        int k = N;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int inorder[] = new int[n];
        for(int j=0; j<k-1; j++){
            String s1 = dict[j];
            String s2 = dict[j+1];
            int len = Math.min(s1.length(), s2.length());
            for(int i=0; i<len; i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    int first = s1.charAt(i) - 97;
                    int second = s2.charAt(i) - 97;
                    adj.get(first).add(second);
                    inorder[second]++;
                    break;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inorder[i]==0){
                q.offer(i);
            }
        }
        String ans = "";
        while(!q.isEmpty()){
            int temp = q.poll();
            ans += (char)(temp+97);
            for(int i: adj.get(temp)){
                inorder[i]--;
                if(inorder[i]==0){
                    q.offer(i);
                }
            }
        }
        return ans;
    }
}