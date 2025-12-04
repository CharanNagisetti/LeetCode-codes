class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int x=0;
        int y=0;
        int fresh=0;
        int minutes=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j,minutes});
                if(grid[i][j]==1) fresh+=1;
            }
        }
        int[] nx={0,0,1,-1};
        int[] ny={1,-1,0,0};
        int convFresh=0;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int a=curr[0];
            int b=curr[1];
            int min=curr[2];
            boolean flag=false;
            for(int i=0;i<4;i++){
                int x1=a+nx[i];
                int y1=b+ny[i];
                if(x1>=0 && x1<m && y1>=0 && y1<n && grid[x1][y1]==1){
                    q.add(new int[]{x1,y1,min+1});
                    grid[x1][y1]=2;
                    convFresh+=1;
                    flag=true;
                }
            }
            if(flag) minutes=min+1;
        }
        if(convFresh!=fresh) return -1;
        return minutes;
    }
}