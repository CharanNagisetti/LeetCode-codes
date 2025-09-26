class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        int ans=0;
        for(int i=n-1;i>=2;i--){
            int x=nums[i];
            int j=0;
            int k=i-1;
            while(j<k){
                if(nums[j]+nums[k]>x){
                    ans+=k-j;
                    k--;
                }else{
                    j++;
                }

            }
        }
        return ans;
    }
}