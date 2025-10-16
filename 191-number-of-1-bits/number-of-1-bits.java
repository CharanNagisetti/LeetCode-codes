class Solution {
    public int hammingWeight(int n) {
        int total=0;
        while(n>0){
            total+=n&1;
            n>>=1;
        }
        return total;
    }
}