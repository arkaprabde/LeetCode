class Solution {
    public long numberOfSubsequences(int[] a)
    {
        Map<Double, Long> mp = new HashMap<>();
        int n = a.length;
        long c = 0;
        for(int i = 4; i < n - 2; i++)
        {
            double q = a[i - 2], r = a[i];
            for(int j = 0; j < i - 3; j++)
            {
                double d = a[j] / q;
                mp.put(d, mp.getOrDefault(d, 0L) + 1);
            }
            for(int j = i + 2; j < n; j++)
                c += mp.getOrDefault(a[j] / r, 0L);
        }
        return c;
    }
}