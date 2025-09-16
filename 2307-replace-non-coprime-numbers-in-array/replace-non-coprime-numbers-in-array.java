class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<n;i++){
            int b=nums[i];
            while (!list.isEmpty() && findCofactors(list.get(list.size()-1), b) > 1) {
                int a = list.remove(list.size() - 1);
                int g = findCofactors(a, b);
                b = (int)lcm(a, b, g);
            }
            list.add(b);
        }
        return list;
    }
    public long lcm(int a, int b, int gcd){
        return (long) a*b/gcd;
    }
    public int findCofactors(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}