class Solution {
    public boolean check(int[][] grid, int m, int n){
        Set<Integer> s=new HashSet<>();
        for(int i=m;i<m+3;i++){
            for(int j=n;j<n+3;j++){
                if(!s.add(grid[i][j])) return false;
                if(grid[i][j]>9 || grid[i][j]<1) return false;
                s.add(grid[i][j]);
            }
        }
        int sum=15;
        for(int i=m;i<m+3;i++){
            if(grid[i][n]+grid[i][n+1]+grid[i][n+2]!=sum) return false;
        }
        for(int j=n;j<n+3;j++){
            if(grid[m][j]+grid[m+1][j]+grid[m+2][j]!=sum) return false;
        }
        if(grid[m][n]+grid[m+1][n+1]+grid[m+2][n+2]!=sum) return false;
        if(grid[m][n+2]+grid[m+1][n+1]+grid[m+2][n]!=sum) return false;
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                if(check(grid,i,j)) ans+=1;
            }
        }
        return ans;
    }
}