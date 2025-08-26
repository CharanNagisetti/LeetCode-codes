class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n=dimensions.length;
        double max=(double) Integer.MIN_VALUE;
        double maxArea=(double) Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int l=dimensions[i][0];
            int b=dimensions[i][1];
            double c = Math.sqrt(l*l + b*b);
            if(c>max){
                maxArea=l*b;
                max=c;
            }else if(c==max){
                if(maxArea<l*b){
                    maxArea=l*b;
                }
            }
        }
        return (int) maxArea;
    }
}