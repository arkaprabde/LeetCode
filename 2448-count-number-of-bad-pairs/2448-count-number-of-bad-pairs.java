class Solution
{
    public long countBadPairs(int[] a)
    {
        Map<Integer, Long> mp = new HashMap<>();
        long s = 0, n = a.length;
        for(int i = 0; i < a.length; i++)
            s += mp.merge(a[i] - i, 1L, Long::sum) - 1;
        return n * (n - 1) / 2 - s;
    }
}