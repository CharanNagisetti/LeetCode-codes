class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int[] ans=new int[n];
        int m=nums2.length;
        for(int i=0;i<n;i++){
            int x=nums1[i];
            int high=-1;
            ans[i]=-1;
            boolean flag=false;
            for(int j=0;j<m;j++){
                if(flag){
                    if(nums2[j]>x){
                        ans[i]=nums2[j];
                        break;
                    }
                }
                if(nums2[j]==x){
                    flag=true;
                }
            }
        }
        return ans;
    }
}