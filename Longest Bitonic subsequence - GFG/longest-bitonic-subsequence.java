//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        int n = arr.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        //lis
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp1[i] < dp1[j] + 1){
                    dp1[i] = dp1[j] + 1;
                }
            }
        }
        //revlis
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j] && dp2[i] < dp2[j] + 1){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        //final_answer
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp1[i]+dp2[i]-1);
        }
        return ans;
    }
    
    public void lis(int n, int arr[], int dp[]){
        
        return;
    }
}