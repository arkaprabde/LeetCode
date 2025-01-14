class Solution
{
    public int[] findThePrefixCommonArray(int[] a, int[] b)
    {
        Map<Integer, Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>();
        int n = a.length, c[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            mp1.put(a[i], mp1.getOrDefault(a[i], 0) + 1);
            mp2.put(b[i], mp2.getOrDefault(b[i], 0) + 1);
            int s = 0;
            for(int x: mp1.keySet())
                s += Math.min(mp1.get(x), mp2.getOrDefault(x, 0));
            c[i] = s;
        }
        return c;
    }
}