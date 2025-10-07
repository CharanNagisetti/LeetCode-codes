class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
        }
        int k=0;
        for(int i=0;i<n/2;i++){
            arr[k++]=l1.get(i);
            arr[k++]=l2.get(i);
        }
        return arr;
    }
}