class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        int total=0;
        while(n>0){
            total+=n&1;
            n>>=1;
        }
        if(total==1) return true;
        return false;
    }
}