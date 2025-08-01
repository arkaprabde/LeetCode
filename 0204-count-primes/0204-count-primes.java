class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean a[] = new boolean[n];
        Arrays.fill(a, true);
        a[0] = false;
        a[1] = false;
        for (int i = 2; i * i <= n; i++) {
            for (int j = 2 * i; j < n; j += i) a[j] = false;
        }
        int c = 0;
        for (boolean x: a) {
            if (x) c++;
        }
        return c;
    }
}