class Solution
{
    public int minimumDiameterAfterMerge(int[][] e1, int[][] e2)
    {
        Map<Integer, List<Integer>> a1 = build(e1);
        Map<Integer, List<Integer>> a2 = build(e2);
        int d1 = a1.isEmpty() ? 0 : diameter(a1);
        int d2 = a2.isEmpty() ? 0 : diameter(a2);
        return Math.max(Math.max(d1, d2), 1 + (d1 + 1) / 2 + (d2 + 1) / 2);
    }

    Map<Integer, List<Integer>> build(int[][] e)
    {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] x : e)
        {
            mp.computeIfAbsent(x[0], k -> new ArrayList<>()).add(x[1]);
            mp.computeIfAbsent(x[1], k -> new ArrayList<>()).add(x[0]);
        }
        return mp;
    }

    int diameter(Map<Integer, List<Integer>> mp)
    {
        if (mp.isEmpty())
            return 0;
        int[] x = {-1, Integer.MIN_VALUE};
        calc(mp, 0, 0, new boolean[mp.size()], x);

        int[] y = {-1, Integer.MIN_VALUE};
        calc(mp, x[0], 0, new boolean[mp.size()], y);

        return y[1];
    }

    void calc(Map<Integer, List<Integer>> mp, int u, int d, boolean[] b, int[] x)
    {
        b[u] = true;
        if (d > x[1])
        {
            x[0] = u;
            x[1] = d;
        }
        for (int v : mp.getOrDefault(u, Collections.emptyList()))
            if (!b[v])
                calc(mp, v, d + 1, b, x);
    }
}
