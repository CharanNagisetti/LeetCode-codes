/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        int ans=Integer.MAX_VALUE;
        if(n==1) return isBadVersion(1) ? 1 : -1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isBadVersion(mid)){
                r=mid;
            }
            else l=mid+1;
        }
        return l;
    }
}