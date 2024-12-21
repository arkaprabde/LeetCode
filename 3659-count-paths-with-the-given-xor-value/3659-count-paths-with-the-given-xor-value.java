class Solution
{
    public int countPathsWithXorValue(int[][] a, int k)
    {
        int m = a.length, n = a[0].length;
        long[][][] dp = new long[m][n][16];
        dp[0][0][a[0][0]] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int x = 0; x < 16; x++)
                    if (dp[i][j][x] > 0)
                    {
                        if (j + 1 < n)
                        {
                            int t = x ^ a[i][j + 1];
                            dp[i][j + 1][t] = (dp[i][j + 1][t] + dp[i][j][x]) % 1000000007;
                        }
                        if (i + 1 < m)
                        {
                            int t = x ^ a[i + 1][j];
                            dp[i + 1][j][t] = (dp[i + 1][j][t] + dp[i][j][x]) % 1000000007;
                        }
                    }
        return (int)dp[m - 1][n - 1][k];
    }
}
