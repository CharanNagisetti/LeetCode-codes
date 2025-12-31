class Solution {
    public void changeMatrix(int[][] matrix, int[][] visited, int i, int j){
        visited[i][j]=1;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int x=0;x<m;x++){
            if(matrix[x][j]!=0){
                matrix[x][j]=0;
                visited[x][j]=1;
            }
        }
        for(int y=0;y<n;y++){
            if(matrix[i][y]!=0){
                matrix[i][y]=0;
                visited[i][y]=1;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0 && visited[i][j]==0){
                    changeMatrix(matrix,visited,i,j);
                }
            }
        }
    }
}