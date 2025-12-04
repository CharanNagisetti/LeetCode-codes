class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] distMatrix=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    distMatrix[nx][ny] = distMatrix[x][y] + 1;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return distMatrix;
    }
}