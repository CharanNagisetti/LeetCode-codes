class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
        int ans=0;
        int low=1;
        int high=x-1;
        while(low<=high){
            int mid=(low+high)/2;
            if((long)mid*mid<=x){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}