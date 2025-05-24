class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int o=m+n;
        int i=0;
        int j=0;
        int count=0;
        int n1=o/2;
        int n2=n1-1;
        int n1ele=0;
        int n2ele=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                if(count == n1) n1ele=nums1[i];
                if(count == n2) n2ele=nums1[i];
                count++;
                i++;
            }
            else{
                if(count == n1) n1ele=nums2[j];
                if(count == n2) n2ele=nums2[j];
                j++;
                count++;
            }
        }
        while(i<m){
            if(count==n1) n1ele=nums1[i];
            if(count == n2) n2ele=nums1[i];
            count++;
            i++;
        }
        while(j<n){
            if(count == n1) n1ele=nums2[j];
            if(count == n2) n2ele=nums2[j];
            count++;
            j++;
        }
        double ans=0;
        if(o%2==1) ans=(double) n1ele;
        else{
            ans=((double)n1ele+(double)n2ele)/2;
        }
        return ans;
    }
}