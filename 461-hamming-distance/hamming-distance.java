class Solution {
    int count=0;
    public int hammingDistance(int x, int y) {
        int z=x^y;
        hammingWeight(z);
        return count;
    }
    public void hammingWeight(int z){
        if(z!=0){
            count++;
            hammingWeight(z & (z-1));
        }
    }
}