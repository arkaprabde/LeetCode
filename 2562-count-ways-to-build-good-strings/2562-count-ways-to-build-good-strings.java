class Solution
{
    static final int mod = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one)
    {
        int dp[] = new int[high + 1];
        dp[0] = 1;
        for(int i = 1; i <= high; i++)
        {
            if(i - zero >= 0)
                dp[i] = dp[i - zero];
            if(i - one >= 0)
                dp[i] = (dp[i] + dp[i - one]) % mod;
        }
        int s = 0;
        for(int i = low; i <= high; i++)
            s = (s + dp[i]) % mod;
        return s;
    }


    /*
    public int countGoodStrings(int low, int high, int zero, int one)
    {
        int dp[] = new int[high + 1];
        Arrays.fill(dp, -1);
        return count(low, high, zero, one, 0, dp);
    }
    int count(int l, int h, int a, int b, int p, int dp[])
    {
        if(p > h)
            return 0;
        if(dp[p] != -1)
            return dp[p];
        int s = 0;
        if(l <= p && p <= h)
            s = 1;
        return dp[p] = (int)((0L + s + count(l, h, a, b, p + a, dp) + count(l, h, a, b, p + b, dp)) % mod);
    }
    */
}