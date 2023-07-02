//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int nums[], int n) {
        // code here
        int ans[] = new int[2];
        int i = 0;
        while(i < nums.length){
            int ele = nums[i];
            int pos = ele - 1;
            if(nums[pos]==ele){
                i++;
            }
            else{
                swap(nums, i, pos);
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=j+1){
                ans[0] = nums[j];
                ans[1] = j+1;
            }
        }
        return ans;
    }
    
    public void swap(int arr[], int i, int correct){
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}