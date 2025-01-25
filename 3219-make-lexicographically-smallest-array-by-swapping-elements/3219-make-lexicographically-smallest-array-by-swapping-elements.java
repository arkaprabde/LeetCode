class Solution
{
    public int[] lexicographicallySmallestArray(int[] a, int p)
    {
        int n = a.length;
        int[] s = new int[n];
        int[][] b = new int[n][];
        for(int i = 0; i < n; i++)
            b[i] = new int[]{a[i], i};
        Arrays.sort(b, (x, y)->x[0] - y[0]);
        Map<Integer, Deque<Integer>> mp = new HashMap<>();
        int[] c = new int[n];
        int v = 0;
        c[b[0][1]] = v;
        mp.put(v, new ArrayDeque<>());
        mp.get(v).addLast(b[0][0]);
        for(int i = 1; i < n; i++)
        {
            if(b[i][0] - mp.get(v).getLast() <= p)
            {
                mp.get(v).addLast(b[i][0]);
                c[b[i][1]]=v;
            }
            else
            {
                v++;
                mp.put(v, new ArrayDeque<>());
                mp.get(v).addLast(b[i][0]);
                c[b[i][1]] = v;
            }
        }
        for(int i=0; i<n; i++)
            s[i]=mp.get(c[i]).pollFirst();
        return s;
    }
}