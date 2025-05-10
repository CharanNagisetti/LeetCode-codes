class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min=weights[0];
        int max=0;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
            if(min<weights[i]){
                min=weights[i];
            }
        }
        int ans=0;
        while(min<=max){
            int mid=(min+max)/2;
            int resDay=daysReq(weights, mid);
            if(resDay<=days){
                ans=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return ans;
    }
    public int daysReq(int[] weights, int capacity){
        int day=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                day+=1;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return day;
    }
}