class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index=-1;
        int max_count=-1;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                count+=mat[i][j];
            }
            if(count>max_count){
                max_count=count;
                index=i;
            }
        }
        return new int[]{index,max_count};
    }
}