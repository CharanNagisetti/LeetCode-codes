class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        long sum=0;
        int min=Integer.MAX_VALUE;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                min=Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j]<0) cnt++;
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(cnt%2==1){
            return sum-2*min;
        }else{
            return sum;
        }
    }
}