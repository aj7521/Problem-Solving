//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][] = new int[a][b];
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int left = 0, up = 0;
                    if(j>0) left = dp[i][j-1];
                    if(i>0) up = dp[i-1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[a-1][b-1];
    }
}