//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static long nthFibonacci(long n){
        // code here
        long prev = 1;
        long prev2 = 0;
        if(n==0) return prev2;
        for(long i=2; i<=n; i++)
        {
            long cur = (prev + prev2)%1000000007;
            prev2 = prev;
            prev = cur;
        }
        return prev%1000000007;
    }
}