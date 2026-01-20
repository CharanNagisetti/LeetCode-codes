class Solution {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int highest=0;
            int x=nums[i];
            while(x>0){
                highest=Math.max(highest,x%10);
                x=x/10;
            }
            if(!map.containsKey(highest)){
                map.put(highest,new ArrayList<>());
            }
            map.get(highest).add(nums[i]);
        }
        int ans=-1;
        for(int x: map.keySet()){
            List<Integer> list=map.get(x);
            int size=list.size();
            if(size<2) continue;
            int sum=0;
            int max1=-1;
            int max2=-1;
            for(int y: list){
                if(y>max1){
                    max2=max1;
                    max1=y;
                }else if(y>max2){
                    max2=y;
                }
            }
            sum+=max1+max2;
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}