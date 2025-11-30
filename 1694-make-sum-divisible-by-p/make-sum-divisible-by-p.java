import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int x : nums) totalSum += x;

        long r = totalSum % p;
        if (r == 0) return 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            // We want prefix[i] - prefix[j] ≡ r (mod p)
            long target = (prefix - r + p) % p;

            if (map.containsKey(target)) {
                int j = map.get(target);
                res = Math.min(res, i - j);
            }

            // store current prefix modulo
            map.put(prefix, i);
        }

        return res == nums.length ? -1 : res;
    }
}
