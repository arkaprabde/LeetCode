class Solution
{
    public int tupleSameProduct(int[] a)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        int s = 0, n = a.length;
        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
            {
                int p = a[i] * a[j], b = mp.getOrDefault(p, 0);
                s += b;
                mp.put(p, b + 1);
            }
        return 8 * s;
    }
}