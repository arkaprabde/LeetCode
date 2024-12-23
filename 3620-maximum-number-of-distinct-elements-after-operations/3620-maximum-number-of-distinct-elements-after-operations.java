class Solution {
    public int maxDistinctElements(int[] a, int k)
    {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int x: a)
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        int c = 0, y = -k, d;
        for(int x: mp.keySet())
        {
            int s = mp.get(x);
            if(y == -k)
                d = k + 1;
            else
                d = Math.min(k + 1, x - y);
            if(s <= d + k)
            {
                c += s;
                y = x - d + s;
            }
            else
            {
                c += d + k;
                y = x + k;
            }
        }
        return c;
    }
}