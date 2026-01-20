class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int min=1;
        int max=nums[0];
        for(int i=0;i<n;i++){
            if(min>nums[i]){
                min=nums[i];
            }
            if(max<nums[i]){
                max=nums[i];
            }
        }
        int ans=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            int sum=getSum(nums,mid);
            if(sum<=threshold){
                ans=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return ans;
    }
    public int getSum(int[] nums, int mid){
        int n=nums.length;
        long sum=0;
        for(int x: nums){
            sum+=(x+mid-1)/mid;
        }
        return (int)sum;
    }
}