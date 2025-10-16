class Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        for(int i=0;i<=n;i++){
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
    }
}