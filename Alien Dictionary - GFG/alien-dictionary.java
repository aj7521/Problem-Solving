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
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++)
        {
            String str = dict[i];
            String ssr = dict[i+1];
            int len = Math.min(str.length(), ssr.length());
            for(int j=0; j<len; j++)
            {
                if(str.charAt(j) != ssr.charAt(j))
                {
                    adj.get(str.charAt(j)-'a').add(ssr.charAt(j)-'a');
                    break;
                }
            }
        }
        int res[] = topoSort(K, adj);
        String ans = new String();
        for(int i=0; i<res.length; i++)
        {
            ans += (char)(res[i] + 97);
        }
        return ans;
    }
    
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        int ans [] = new int[V];
        int indegree[] = new int[V];
        //take all indegrees
        for(int i=0; i<V; i++)
        {
            for(Integer j: adj.get(i))
            {
                indegree[j]++;
            }
        }
        //push all the 0 indegree elements in the queue
        for(int i=0; i<V; i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        //take out the peek element and add to answer
        int p = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans[p++] = node;
            //and decrement the indegree and push if indegree==0
            for(Integer i: adj.get(node))
            {
                indegree[i]--;
                if(indegree[i]==0)
                {
                    q.offer(i);
                }
            }
        }
        
        return ans;
    }
}