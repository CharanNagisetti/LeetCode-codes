class Solution {
    public void dfs(char[][] board, int[][] visited, int m,int n){
        visited[m][n]=1;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        int x=visited.length;
        int y=visited[0].length;
        for(int i=0;i<4;i++){
            int nx=m+dx[i];
            int ny=n+dy[i];
            if(nx>=0 && nx<x && ny>=0 && ny<y){
                if(board[nx][ny]=='O' && visited[nx][ny]==0){
                    dfs(board,visited,nx,ny);
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && visited[0][i]==0){
                dfs(board,visited,0,i);
            }
            if(board[m-1][i]=='O' && visited[m-1][i]==0){
                dfs(board,visited,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && visited[i][0]==0){
                dfs(board,visited,i,0);
            }
            if(board[i][n-1]=='O' && visited[i][n-1]==0){
                dfs(board,visited,i,n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}