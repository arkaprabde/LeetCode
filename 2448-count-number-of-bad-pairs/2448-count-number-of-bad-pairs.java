class Solution
{
    public long countBadPairs(int[] a)
    {
        Map<Integer, Long> mp = new HashMap<>();
        long s = 0, n = a.length;
        for(int i = 0; i < a.length; i++)
        {
            a[i] -= i;
            mp.put(a[i], mp.getOrDefault(a[i], 0L) + 1);
        }
        for(long x: mp.values())
            s += x * (x - 1) / 2;
        return n * (n - 1) / 2 - s;
    }
}