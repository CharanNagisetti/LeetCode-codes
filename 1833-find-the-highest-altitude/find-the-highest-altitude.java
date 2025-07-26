class Solution {
    public int largestAltitude(int[] gain) {
        int highest=0;
        int count=0;
        for(int i=0;i<gain.length;i++){
            count+=gain[i];
            if(count>highest){
                highest=count;
            }
        }
        return highest;
    }
}