class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long s = 0, c = 0;
        int i = 0;
        List<Integer> d = new ArrayList<>();
        for (long m = n; m > 0; m /= 10) {
            s += m % 10;
            d.add((int)(m % 10));
        }
        d.add(0);
        while (s > target) {
            s = s - d.get(i) + 1;
            c += (10 - d.get(i)) * (long)Math.pow(10, i);
            d.set(i + 1, d.get(i + 1) + 1);
            i++;
        }
        return c;
    }
}