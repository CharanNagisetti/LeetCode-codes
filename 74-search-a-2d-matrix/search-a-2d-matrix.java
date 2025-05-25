class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int a=matrix[i][0];
            int b=matrix[i][m-1];
            if(a<=target && target<=b){
                int low=0;
                int high=m-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    }
                    else if(matrix[i][mid]>target){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
            }else{
                continue;
            }
        }
        return false;
    }
}