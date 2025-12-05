class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int count=0;
        for(int i=1;i<n;i++){
            int s1=sum(nums,l,i-1);
            int s2=sum(nums,i,r);
            if((s2-s1)%2==0) count++;
        }
        return count;
    }
    public int sum(int[] nums, int l, int r){
        int s=0;
        for(int i=l;i<=r;i++){
            s+=nums[i];
        }
        return s;
    }
}