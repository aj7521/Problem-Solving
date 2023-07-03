class Solution {
    int count = 0;
    public int reversePairs(int[] a) {
        int n = a.length;
        mergeSort(a, 0, n-1);
        return count;
    }
    private void merge(int[] arr, int low, int mid, int high) {
        int r = mid + 1;
        for(int i=low; i<=mid; i++){
            while(r <=high && arr[i] > (long)2*arr[r]){
                r++;
            }
            count += (r - (mid + 1));
        }
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low;    
        int right = mid + 1;  

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } 
            else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high); 
    }
}