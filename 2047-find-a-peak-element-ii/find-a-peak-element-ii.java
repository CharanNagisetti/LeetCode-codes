class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int column=mat[0].length;
        int low=0;
        int high=column-1;
        while(low<=high){
            int mid=(low+high)/2;
            int[] max=maxEle(mat,mid,row);
            int left= (mid-1 >=0) ? mat[max[1]][mid-1] : -1;
            int right = (mid+1<column) ? mat[max[1]][mid+1] : -1;
            if(left<=max[0] && max[0]>=right){
                return new int[]{max[1], mid};
            }
            else if(max[0]<left) high=mid-1;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
    public int[] maxEle(int[][] mat, int column, int row){
        int max=-1;
        int maxRow=-1;
        for(int i=0;i<row;i++){
            if(mat[i][column]>max){
                max=mat[i][column];
                maxRow=i;
            }
        }
        return new int[]{max,maxRow};
    }
}