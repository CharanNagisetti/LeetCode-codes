class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length<k) return -1;
        int min=Integer.MIN_VALUE;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(min<=nums[i]){
                min=nums[i];
            }
            max+=nums[i];
        }
        while(min<=max){
            int mid=(min+max)/2;
            int count = func(nums, mid);
            if(count>k){ min=mid+1;}
            else{
                max=mid-1;
            }
        }
        return min;
    }
    public int func(int[] nums, int k){
        int num=1;
        int allo_num=0;
        for(int i=0;i<nums.length;i++){
            if(allo_num+nums[i]<=k){
                allo_num+=nums[i];
            }else{
                num++;
                allo_num=nums[i];
            }
        }
        return num;
    }
}