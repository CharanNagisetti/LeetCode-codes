class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int m=queries.length;
        int n=nums.length;
        int sum=0;        
        int[] ans=new int[m];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                sum+=nums[i];
            }
        }
        for(int i=0;i<m;i++){
            int j=queries[i][1];
            int val=queries[i][0];
            if(nums[j]%2==0){
                sum-=nums[j];
            }
            nums[j]+=val;
            if(nums[j]%2==0){
                sum+=nums[j];
            }
            ans[i]=sum;
        }
        return ans;
    }
}