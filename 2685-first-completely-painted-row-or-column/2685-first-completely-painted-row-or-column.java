class Solution
{
    public int firstCompleteIndex(int[] a, int[][] p)
    {
        Map<Integer, int[]> mp = new HashMap<>();
        Map<Integer, List<Integer>> smp1 = new HashMap<>(), smp2 = new HashMap<>();
        int n = p.length, m = p[0].length;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                mp.put(p[i][j], new int[]{i, j});
        for(int i = 0; i < n; i++)
            smp1.put(i, new ArrayList<>());
        for(int i = 0; i < m; i++)
            smp2.put(i, new ArrayList<>());
        for(int i = 0; i < a.length; i++)
        {
            int b[] = mp.get(a[i]);
            smp1.get(b[0]).add(b[1]);
            smp2.get(b[1]).add(b[0]);
            if(smp1.get(b[0]).size() == m || smp2.get(b[1]).size() == n)
                return i;
        }
        return -1;
    }
}