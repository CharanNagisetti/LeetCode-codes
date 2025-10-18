class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long curr = Long.MIN_VALUE; // handle large negatives safely

        for (int x : nums) {
            long low = x - k;
            long high = x + k;
            if (curr < low) curr = low;
            if (curr <= high) { 
                count++;
                curr++;
            }
        }

        return count;
    }
}
