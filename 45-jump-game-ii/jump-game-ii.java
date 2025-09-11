class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n<=1) return 0;
        if(nums[0]==0) return -1;
        int count=1;
        int max=nums[0];
        int steps=nums[0];
        for(int i=1;i<n;i++){
            if(i==n-1) return count;
            max=Math.max(max, i+nums[i]);
            steps--;
            if(steps==0){
                count++;
                if(i>=max) return -1;
                steps=max-i;
            }
        }
        return count;
    }
}