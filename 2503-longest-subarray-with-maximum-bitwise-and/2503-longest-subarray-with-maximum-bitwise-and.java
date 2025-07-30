class Solution {
    public int longestSubarray(int[] nums) {
        int mx = 0, c = 0, v = 1;
        for (int x: nums) {
            if (x > mx) {
                mx = x;
                c = v = 1;
            } else if (x == mx) {
                c++;
                if (v < c) {
                    v = c;
                }
            } else c = 0;
        }
        return v;
    }
}