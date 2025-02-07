class Solution
{
    public int[] queryResults(int k, int[][] a)
    {
        Map<Integer,Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>();
        int n = a.length, s = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
        {
            int p = a[i][0], c = a[i][1];
            if(mp1.containsKey(p))
            {
                int x = mp2.get(mp1.get(p)) - 1;
                if(x == 0)
                {
                    mp2.remove(mp1.get(p));
                    s--;
                }
                else
                    mp2.put(mp1.get(p), x);
            }
            mp1.put(p, c);
            int x = mp2.getOrDefault(c, 0) + 1;
            mp2.put(c, x);
            if(x == 1) s++;
            ans[i] = s;
        }
        return ans;
    }
}