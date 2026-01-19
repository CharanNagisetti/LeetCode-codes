class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[r]!=arr[r-1]) return arr[r];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];
            if((mid%2==0 && arr[mid]==arr[mid+1]) || (mid%2==1 && arr[mid]==arr[mid-1])) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}