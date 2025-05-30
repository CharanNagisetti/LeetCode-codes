class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int count=1;
        int prevEnd=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(prevEnd<pairs[i][0]){
                count+=1;
                prevEnd=pairs[i][1];
            }
        }
        return count;
    }
}