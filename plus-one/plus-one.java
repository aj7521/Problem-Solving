class Solution {
    public int[] plusOne(int[] digits) {
        reverse(digits);
        int n = digits.length;
        List<Integer> arr = new ArrayList<>();
        int carry = 1;
        int i = 0;
        boolean flag = false;
        while(i<n){
            int sum = digits[i] + carry;
            i++;
            if(sum < 10){
                arr.add(sum);
                flag = true;
                break;
            }
            else{
                arr.add(0);
            }
        }
        if(i==n && !flag){
            arr.add(1);
        }
        while(i<n){
            arr.add(digits[i]);
            i++;
        }
        int ans[] = new int[arr.size()];
        for(int j=0; j<arr.size(); j++){
            ans[j] = arr.get(arr.size()-j-1);
        }
        return ans;
    }

    public void reverse(int arr[]){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
}