class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset=new ArrayList<>();
        backTrack(subset, new ArrayList<>(), nums, 0);
        return subset;
    }
    public void backTrack(List<List<Integer>> subset, ArrayList<Integer> list, int[] nums, int index){
        subset.add(new ArrayList<>(list));
        int n=nums.length;
        for(int i=index;i<n;i++){
            list.add(nums[i]);
            backTrack(subset,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}