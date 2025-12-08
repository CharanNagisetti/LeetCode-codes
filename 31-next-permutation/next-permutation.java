class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        boolean check=false;
        for(int i=n-2;i>=0;i--){
            int start=i;
            int highest=Integer.MAX_VALUE;
            int st=nums[i];
            int idx=start+1;
            for(int j=start+1;j<n;j++){
                if(nums[j] > st && nums[j] < highest){
                    highest = nums[j];
                    idx = j;
                }

            }
            if (highest != Integer.MAX_VALUE) {
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                Arrays.sort(nums,i+1,n);
                check=true;
                break;
            }
        }
        if(!check) reverse(nums, 0, n-1);
    }
    public void reverse(int[] arr, int start, int end) {
        int left = start, right = end;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

}