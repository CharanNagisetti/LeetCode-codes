class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int x=nums[i];
            ans[i]=-1;
            for(int j=i+1;j<i+n;j++){
                int l=j%n;
                if(nums[l]>x){
                    ans[i]=nums[l];
                    break;
                }
            }
        }
        return ans;
    }
}