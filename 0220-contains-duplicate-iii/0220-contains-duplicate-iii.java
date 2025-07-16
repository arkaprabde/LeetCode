class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int d) {
        Map<Long, Long> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long n = (long) nums[i] - Integer.MIN_VALUE, m = n / ((long) d + 1);
            if (mp.containsKey(m)
                    || (mp.containsKey(m - 1) && n - mp.get(m - 1) <= d)
                    || (mp.containsKey(m + 1) && mp.get(m + 1) - n <= d))
                return true;
            if (mp.size() >= k)
                mp.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) d + 1));
            mp.put(m, n);
        }
        return false;
    }
}