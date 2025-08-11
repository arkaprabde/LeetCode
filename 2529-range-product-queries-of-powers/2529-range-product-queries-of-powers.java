class Solution {
    public int[] productQueries(int n, int[][] q) {
        List<Long> arr = new ArrayList<>();
        int x = 1, MOD = 1_000_000_007;
        long y = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (y == 0) {
                    arr.add(y = 1L * x);
                } else {
                    arr.add(y = (x * y) % MOD);
                }
            }
            x <<= 1;
            n >>= 1;
        }
        int ans[] = new int[q.length];
        for (int i = 0; i < q.length; i++)
            ans[i] = (int)(arr.get(q[i][1]) * (q[i][0] > 0? pow(arr.get(q[i][0] - 1)): 1) % MOD);
        return ans;
    }

    long pow(long x) {
        long r = 1, MOD = 1_000_000_007, e = MOD - 2;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * x) % MOD;
            x = (x * x) % MOD;
            e >>= 1;
        }
        return r;
    }
}