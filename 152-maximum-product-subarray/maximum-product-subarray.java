class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0];
        int maxSoFar=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            int current=nums[i];
            int temp=max;
            max=Math.max(current,Math.max(current*max,current*min));
            min=Math.min(current,Math.min(current*temp,current*min));
            maxSoFar=Math.max(max,maxSoFar);
        }
        return maxSoFar;
    }
}