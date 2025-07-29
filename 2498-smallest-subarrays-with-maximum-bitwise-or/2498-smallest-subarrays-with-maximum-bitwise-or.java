class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length, a[] = new int[31], res[] = new int[n];
        Arrays.fill(a, -1);
        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            for (int b = 0; b < 31; b++) {
                if ((nums[i] & 1 << b) == 0) {
                    if (a[b] != -1) j = Math.max(j, a[b]);
                } else a[b] = i;
            }
            res[i] = j - i + 1;
        }
        return res;
    }
}