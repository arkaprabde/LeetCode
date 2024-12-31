class Solution
{
    int dp[] = new int[366];
    public int mincostTickets(int[] d, int[] c)
    {
        Arrays.fill(dp, -1);
        return calc(0, d, c);
    }

    int calc(int i, int d[], int c[])
    {
        if(i >= d.length)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        return dp[i] = Math.min(c[0] + calc(i + 1, d, c), Math.min(c[1] + calc(get(d, d[i] + 7), d, c), c[2] + calc(get(d, d[i] + 30), d, c)));
    }

    int get(int d[], int x)
    {
        int l = 0, h = d.length;
        while(l < h)
        {
            int m = l + (h - l) / 2;
            if(d[m] >= x)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}