class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int x=nums[i];
            int sum=0;
            while(x>0){
                sum+=x%10;
                x=x/10;
            }
            if(!map.containsKey(sum)){
                map.put(sum,new ArrayList<>());
            }
            map.get(sum).add(nums[i]);
        }
        int ans=-1;
        for(int x: map.keySet()){
            List<Integer> l=map.get(x);
            System.out.print(x+" "+l);
            int size=l.size();
            if(size<2) continue;
            int m1=-1;
            int m2=-1;
            for(int y: l){
                if(y>m1){
                    m2=m1;
                    m1=y;
                }else if(y>m2){
                    m2=y;
                }
            }
            ans=Math.max(ans,m1+m2);
        }
        return ans;
    }
}