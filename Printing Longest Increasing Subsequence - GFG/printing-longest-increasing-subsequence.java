//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]){
        // Code here
        int dp[] = new int[n];
        int hash[] = new int [n];
        //dp
        Arrays.fill(dp, 1);
        //hash
        for(int i=0; i<n; i++){
            hash[i] = i;
        }
        int findMax = 0;
        int findInd = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        hash[i] = j;
                        if(findMax < dp[i]){
                            findMax = dp[i];
                            findInd = i;
                        }
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(hash[findInd] != findInd){
            ans.add(arr[findInd]);
            findInd = hash[findInd];
        }
        ans.add(arr[findInd]);
        Collections.reverse(ans);
        return ans;
    }
}
