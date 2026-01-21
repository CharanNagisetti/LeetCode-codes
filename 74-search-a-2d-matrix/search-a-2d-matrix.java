class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=0;
        int left=i;
        int right=m-1;
        int i_target=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[mid][0]<=target){
                i_target=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        left=j;
        right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[i_target][mid]==target) return true;
            else if(matrix[i_target][mid]<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
}