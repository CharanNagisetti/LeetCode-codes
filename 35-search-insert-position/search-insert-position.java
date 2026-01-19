class Solution {
    public int searchInsert(int[] arr, int target) {
        int l=0;
        int r=arr.length-1;
        if(target<arr[0]) return 0;
        if(target>arr[r]) return r+1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}