class Solution {
    public int maxSum(int[] nums) {
        int n=nums.length;
        int[] highest=new int[n];
        for(int i=0;i<n;i++){
            int x=nums[i];
            int high=0;
            while(x>0){
                int temp=x%10;
                x=x/10;
                high=Math.max(high,temp);
            }
            highest[i]=high;
        }
        for(int i=0;i<n;i++){
            System.out.print(highest[i]+" ");
        }
        int ans=-1;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(highest[i]==highest[j]){
                    int temp=nums[i]+nums[j];
                    System.out.print(nums[i]+" "+nums[j]+"   ");
                    ans=Math.max(ans,temp);
                }
            }
        }
        return ans;
    }
}