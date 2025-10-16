class Solution {
    public int missingNumber(int[] nums) {
        int res=nums.length;
        for(int i=0;i<nums.length;i++){
            int x=i^nums[i];
            res=res^x;
        }
        return res;
    }
}

