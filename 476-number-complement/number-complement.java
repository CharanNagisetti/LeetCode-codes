class Solution {
    public int findComplement(int num) {
        int mask=0;
        int x=num;
        while(num>0){
            mask=(mask<<=1) | 1;
            num>>=1;
        }
        return x ^ mask;
    }
}