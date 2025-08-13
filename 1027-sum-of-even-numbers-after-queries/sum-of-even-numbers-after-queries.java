class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int pos=queries[i][1];
            nums[pos]+=queries[i][0];
            ans[i]=sum(nums);
        }
        return ans;
    }
    public int sum(int[] arr){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                sum+=arr[i];
            }
        }
        return sum;
    }
}