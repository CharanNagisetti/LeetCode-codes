class Solution {
    public ArrayList<Integer> findDivisors(int x){
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i*i<=x;i++){
            if(x%i==0){
                if(i==(x/i)) arr.add(i);
                else{
                    arr.add(i);
                    arr.add(x/i);
                }
            }
        }
        return arr;
    }
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> arr=findDivisors(nums[i]);
            if(arr.size()==4){
                for(int x: arr){
                    sum+=x;
                }
            }
        }
        return sum;
    }
}