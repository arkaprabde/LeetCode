class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s = 0, n = gas.length, idx = -1;
        for (int i = 0; i < n; i++) s += gas[i] - cost[i];
        if (s < 0) return -1;
        s = 0;
        for (int i = 0; i < n; i++) {
            s += gas[i] - cost[i];
            if (s >= 0) {
                if (idx < 0) idx = i;
            }
            else {
                idx = -1;
                s = 0;
            }
        }
        return idx;
    }
}