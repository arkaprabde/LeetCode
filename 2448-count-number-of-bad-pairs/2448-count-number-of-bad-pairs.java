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
            s += mp.get(a[i]) - 1;
        }
        return n * (n - 1) / 2 - s;
    }
}