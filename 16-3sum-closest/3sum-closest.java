class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int sum=0;
        int closest=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=n-1;
            while(left<right){
                sum=nums[i]+nums[right]+nums[left];
                int diff=Math.abs(sum-target);
                if(diff<Math.abs(closest-target)){
                    closest=sum;
                }
                if(sum<target){
                    left++;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    return target;
                }
            }
        }
        return closest;
    }
}