class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int area=0;
            if(height[right]>height[left]){
                area=(right-left)*height[left];
                left++;
            }
            else{
                area=(right-left)*height[right];
                right--;
            }
            if(area>max){
                max=area;
            }
        }
        return max;
    }
}