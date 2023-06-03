//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][] = new int[N][sum+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return count(N-1, arr, sum, dp);
    }
    
    public static boolean count(int i, int arr[], int sum, int dp[][]){
        if(sum==0){
            return true;
        }
        if(i==0){
            if(sum-arr[0]==0) return true;
            return false;
        }
        if(dp[i][sum]!=-1) return dp[i][sum]==1?true:false;
        boolean np = count(i-1, arr, sum, dp);
        boolean p = false;
        if(arr[i]<=sum){
            p = count(i-1, arr, sum-arr[i], dp);
            dp[i][sum] = np|p?1:0;
        }
        
        return np|p;
    }
}