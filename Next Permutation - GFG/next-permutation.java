//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        List<Integer> ans = new ArrayList<>();
        int bp = -1;
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                bp = i;
                break;
            }
        }
        if(bp==-1){
            for(int i=arr.length-1; i>=0; i--){
                ans.add(arr[i]);
            }
            return ans;
        }
        int swapNum = -1;
        for(int i=arr.length-1; i>=bp; i--){
            if(arr[i] > arr[bp]){
                swapNum = i;
                break;
            }
        }
        int temp = arr[bp];
        arr[bp] = arr[swapNum];
        arr[swapNum] = temp;
        
        reverse(arr, bp+1, arr.length-1);
        
        for(int i=0; i<arr.length; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    
    public static void reverse(int arr[], int low, int high){
        while(low<=high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return;
    }
}