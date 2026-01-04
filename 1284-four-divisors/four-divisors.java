class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int x: nums){
            int curr=0;
            int cnt=0;
            for(int i=1;i*i<=x;i++){
                if(x%i==0){
                    if(i==x/i){
                        curr+=i;
                        cnt+=1;
                    }else{
                        curr+=i;
                        curr+=x/i;
                        cnt+=2;
                    }
                }
                if(cnt>4) break;
            }
            if(cnt==4) ans+=curr;
        }
        return ans;
    }
}