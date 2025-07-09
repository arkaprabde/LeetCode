class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length, s = 0, mx = 0;
        int free[] = new int[n + 1];
        free[0] = startTime[0];
        for(int i = 1; i < n; i++) free[i] = startTime[i] - endTime[i - 1];
        free[n] = eventTime - endTime[n - 1];
        for(int i = 0; i <= n; i++) {
            s += free[i];
            if (i >= k) {
                mx = Math.max(mx, s);
                s -= free[i - k];
            }
        }
        return mx;
    }
}