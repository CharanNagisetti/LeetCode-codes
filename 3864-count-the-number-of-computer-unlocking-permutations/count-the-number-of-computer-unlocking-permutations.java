class Solution {
    public long fact(int x){
        long mod=1_000_000_007;
        long ans=1;
        for(long i=1;i<=x;i++){
            ans*=i;
            ans%=mod;
        }
        return ans;
    }
    public int countPermutations(int[] complexity) {
        long mod=1_000_000_007;
        int n=complexity.length;
        Arrays.sort(complexity, 1, n);
        if(complexity[0]<complexity[1]){
            return (int) (fact(n-1)%mod);
        }
        return 0;
    }
}