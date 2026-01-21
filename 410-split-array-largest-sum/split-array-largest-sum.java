class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int min=nums[0];
        int sum=0;
        int max=nums[0];
        for(int x: nums){
            if(min>x){
                min=x;
            }
            if(max<x){
                max=x;
            }
            sum+=x;
        }
        if(n==k) return max;
        int left=max;
        int right=sum;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            int counter=numSplits(nums,mid);
            if(counter<=k){ 
                right=mid-1;
                ans=mid;
            }
            else left=mid+1;
        }
        return ans;
    }
    public int numSplits(int[] nums, int check){
        int sum=0;
        int cnt=0;
        for(int x: nums){
            if(sum+x<=check){
                sum+=x;
            }else{
                sum=x;
                cnt++;
            }
        }
        return cnt+1;
    }
}