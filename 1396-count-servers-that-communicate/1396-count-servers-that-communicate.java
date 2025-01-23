class Solution
{
    public int countServers(int[][] a)
    {
        int n = a.length, m = a[0].length, s1[] = new int[n], s2[] = new int[m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(a[i][j] == 1)
                {
                    s1[i]++;
                    s2[j]++;
                }
        int c = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(a[i][j] == 1 && (s1[i] > 1 || s2[j] > 1))
                    c++;
        return c;
    }
}