class Solution
{
    int c = 0;
    int calc(List<List<Integer>> l, int v[], int n, int p, int k)
    {
        int s = v[n];
        for(int x: l.get(n))
            if(x != p)
                s += calc(l, v, x, n, k);
        if(s % k == 0)
            c++;
        return s % k;
    }
    public int maxKDivisibleComponents(int n, int[][] e, int[] v, int k)
    {
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i < n; i++)
            l.add(new ArrayList<Integer>());
        for(int x[]: e)
        {
            l.get(x[0]).add(x[1]);
            l.get(x[1]).add(x[0]);
        }
        calc(l, v, 0, -1, k);
        return c;
    }
}