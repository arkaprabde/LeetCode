class Solution
{
    public int lenLongestFibSubseq(int[] a)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < a.length; i++)
            mp.put(a[i], i);
        int mx = 0;
        for(int i = 0; i < a.length - 1; i++)
        {
            for(int j = i + 1; j < a.length; j++)
            {
                int x = a[i], y = a[j], l = 2;
                while(mp.containsKey(x + y))
                {
                    int z = x + y;
                    x = y;
                    y = z;
                    l++;
                    mx = Math.max(mx, l);
                }
            }
        }
        return mx > 2? mx: 0;
    }
}