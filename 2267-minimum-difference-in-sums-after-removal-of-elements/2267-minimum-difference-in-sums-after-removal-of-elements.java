class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long s[] = new long[n + 1], sum = 0;
        PriorityQueue<Integer> q1 = new PriorityQueue<>((x, y) -> y - x), q2 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            s[0] += nums[i];
            q1.add(nums[i]);
        }
        for (int i = n; i < 2 * n; i++) {
            q1.add(nums[i]);
            s[i - n + 1] = s[i - n] + nums[i] - q1.poll();
        }
        for (int i = nums.length - 1; i >= 2 * n; i--) {
            sum += nums[i];
            q2.add(nums[i]);
        }
        s[n] -= sum;
        for (int i = 2 * n - 1; i >= n; i--) {
            q2.add(nums[i]);
            sum = sum + nums[i] - q2.poll();
            s[i - n] = s[i - n] - sum;
        }
        return Arrays.stream(s).min().getAsLong();
    }
}