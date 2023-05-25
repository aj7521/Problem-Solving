//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        List<Integer> al = new ArrayList<>();
        for(int i=0; i<size; i++){
            if(al.size()==0){
                al.add(a[i]);
            }
            else
            {
                if(a[i] > al.get(al.size()-1)){
                    al.add(a[i]);
                }
                else
                {
                    int bsInd = binarySearch(0, al.size()-1, a[i], al);
                    al.set(bsInd, a[i]);
                }
            }
        }
        return al.size();
    }
    
    static int binarySearch(int l, int r, int x, List<Integer> al){
        if(r>=l){
            int m = l + (r - l) / 2;
            if(al.get(m)==x){
                return m;
            }
            else if(al.get(m)>x){
                return binarySearch(l, m-1, x, al);
            }
            else
            {
                return binarySearch(m+1, r, x, al);
            }
        }
        return l;
    }
} 