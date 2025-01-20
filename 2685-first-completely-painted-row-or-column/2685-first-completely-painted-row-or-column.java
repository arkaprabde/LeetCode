class Solution
{
    public int firstCompleteIndex(int[] a, int[][] p)
    {
        int n = p.length, m = p[0].length, b[] = new int[n * m + 1], s = n * m + 1;
        for(int i = 0; i < n * m; i++)
            b[a[i]] = i;
        for(int i = 0; i < n; i++)
        {
            int mx = 0;
            for(int j = 0; j < m; j++)
                mx = Math.max(mx, b[p[i][j]]);
            s = Math.min(s, mx);
        }
        for(int i = 0; i < m; i++)
        {
            int mx = 0;
            for(int j = 0; j < n; j++)
                mx = Math.max(mx, b[p[j][i]]);
            s = Math.min(s, mx);
        }
        return s;
    }
}