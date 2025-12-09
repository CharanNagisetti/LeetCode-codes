class Solution {
    public int specialTriplets(int[] nums) {
        long mod=1_000_000_007;
        int n=nums.length;
        Map<Long, Long> leftMap=new HashMap<>();
        Map<Long, Long> rightMap=new HashMap<>();

        for(long x: nums){
            rightMap.put(x, rightMap.getOrDefault(x,0L)+1);
        }

        long cnt=0;
        for(int i=0;i<n;i++){
            long num=nums[i];
            rightMap.put(num,rightMap.get(num)-1);
            long target=num*2;
            long left=leftMap.getOrDefault(target,0L);
            long right=rightMap.getOrDefault(target,0L);

            cnt=(cnt+(left*right)%mod)%mod;
            leftMap.put(num,leftMap.getOrDefault(num,0L)+1);
        }
        return (int) cnt;
    }
}