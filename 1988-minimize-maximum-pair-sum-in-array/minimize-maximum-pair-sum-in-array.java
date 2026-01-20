class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ans=0;
        while(l<r){
            int sum=nums[l]+nums[r];
            ans=Math.max(ans,sum);
            l++;
            r--;
        }
        return ans;
    }
}