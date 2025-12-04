class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target=image[sr][sc];
        if(target==color) return image;
        int m=image.length;
        int n=image[0].length;
        int[] x={0,0,1,-1};
        int[] y={1,-1,0,0};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int s1=curr[0];
            int s2=curr[1];
            image[s1][s2]=color;
            for(int i=0;i<4;i++){
                int x1=x[i]+s1;
                int y1=y[i]+s2;
                if(x1>=0 && x1<m && y1>=0 && y1<n && image[x1][y1]==target){
                    image[x1][y1]=color;
                    q.add(new int[]{x1,y1});
                }
            }
        }
        return image;
    }
}