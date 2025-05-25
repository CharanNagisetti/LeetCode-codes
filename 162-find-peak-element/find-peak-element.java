class Solution {
    public int findPeakElement(int[] arr) {
        if(arr.length==1) return 0;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            boolean left = (mid == 0 || arr[mid] >= arr[mid - 1]);
            boolean right = (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);
            if(left && right){
                return mid;
            }else if(mid>0 && arr[mid-1]>arr[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}