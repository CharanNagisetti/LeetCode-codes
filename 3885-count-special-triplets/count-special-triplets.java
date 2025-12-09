class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007;
        int n = nums.length;

        Map<Long, Long> right = new HashMap<>();
        Map<Long, Long> left = new HashMap<>();

        // Fill right map initially with all frequency
        for (long x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        long ans = 0;

        // iterate j
        for (int j = 0; j < n; j++) {
            long x = nums[j];
            right.put(x, right.get(x) - 1); // element now becomes middle, so remove one from right

            long target = x * 2;

            long leftCount = left.getOrDefault(target, 0L);
            long rightCount = right.getOrDefault(target, 0L);

            ans = (ans + (leftCount * rightCount) % MOD) % MOD;

            // move nums[j] to left map
            left.put(x, left.getOrDefault(x, 0L) + 1);
        }

        return (int) ans;
    }
}
