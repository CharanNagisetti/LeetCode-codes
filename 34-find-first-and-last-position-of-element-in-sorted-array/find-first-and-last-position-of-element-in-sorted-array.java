class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int a1=search(nums,target,true);
        int a2=search(nums,target,false);
        ans[0]=a1;
        ans[1]=a2;
        return ans;
    }
    public int search(int[] nums, int target, boolean flag){
        int min=0;
        int max=nums.length-1;
        int bound=-1;
        while(min<=max){
            int mid=(min+max)/2;
            if(nums[mid]<target){
                min=mid+1;
            }else if(nums[mid]>target){
                max=mid-1;
            }
            else{
                bound=mid;
                if(flag){
                    max=mid-1;
                }else{
                    min=mid+1;
                }
            }
        }
        return bound;
    }
}