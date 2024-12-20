class Solution
{
    public long maxScore(int[] a, int[] b)
    {
        int n = b.length, i, j;
        long dp[][] = new long[4][n];
        for(i = 0; i < 4; i++)
            Arrays.fill(dp[i], Long.MIN_VALUE);
        dp[0][0] = (long)a[0] * b[0];
        for(i = 1; i < n; i++)
            dp[0][i] = Math.max(dp[0][i - 1], (long)a[0] * b[i]);
        for(i = 1; i < 4; i++)
            for(j = i; j < n; j++)
                dp[i][j] = Math.max(dp[i][j - 1], (long)a[i] * b[j] + dp[i - 1][j - 1]);
        return dp[3][n - 1];
    }
}