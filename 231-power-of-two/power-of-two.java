class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        int x=n-1;
        if(((n & x)==0) && n>0) return true;
        return false;
    }
}