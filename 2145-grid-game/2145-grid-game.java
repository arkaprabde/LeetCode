class Solution
{
    public long gridGame(int[][] a)
    {
        long mn = Long.MAX_VALUE, s1 = 0, s2 = 0;
        int n = a[0].length;
        for(int x: a[0])
            s1 += x;
        for(int i = 0; i < n; i++)
        {
            s1 -= a[0][i];
            mn = Math.min(mn, Math.max(s1, s2));
            s2 += a[1][i];
        }
        return mn;
    }
}