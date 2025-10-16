class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        for (int num : nums) {
            int r = (num % value + value) % value; // handle negative numbers
            count[r]++;
        }
        int x = 0;
        while (true) {
            int r = x % value;
            if (count[r] > 0) {
                count[r]--;
                x++;
            } else {
                return x;
            }
        }
    }
}
