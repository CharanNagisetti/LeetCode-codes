class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] ans=new int[2];
        int l=0;
        int r=arr.length-1;
        int occ1=-1;
        //first occurence
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                occ1=mid;
                r=mid-1;
            }
            else if(arr[mid]>target) r=mid-1;
            else l=mid+1;
        }
        //last occurence
        l=0;
        r=arr.length-1;
        int occ2=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                occ2=mid;
                l=mid+1;
            }
            else if(arr[mid]>target) r=mid-1;
            else l=mid+1;
        }
        ans[0]=occ1;
        ans[1]=occ2;
        return ans;
    }
}