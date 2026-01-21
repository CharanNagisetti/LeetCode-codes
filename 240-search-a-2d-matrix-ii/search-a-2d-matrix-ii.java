class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m-1;
        int i=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[i][0]<=target){
                i=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        left=0;
        right=n-1;
        int j=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[0][mid]<=target){
                j=mid;
                left=mid+1;
            }
            else right=mid-1;
        }
        for(int k=0;k<=i;k++){
            for(int l=0;l<=j;l++){
                if(matrix[k][l]==target) return true;
            }
            System.out.println();
        }
        return false;
    }
}