class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((m*k)>bloomDay.length){
            return -1;   
        }
        int min=bloomDay[0];
        int max=bloomDay[0];
        for(int i=0;i<bloomDay.length;i++){
            if(min>bloomDay[i]){
                min=bloomDay[i];
            }
            if(max<bloomDay[i]){
                max=bloomDay[i];
            }
        }
        if(min==max) return min;
        int ans=-1;
        while(min<=max){
            int mid=(min+max)/2;
            int count=countBouq(bloomDay, mid, m, k);
            if(count>=m){
                ans=mid;
                max=mid-1;
            }
            else if(count<m){
                min=mid+1;
            }
        }
        return ans;
    }
    public int countBouq(int[] bloomDay, int day, int m, int k){
        int count=0;
        int ans=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                ans+=(count/k);
                count=0;
            }
        }
        ans+=count/k;
        return ans;
    }
}