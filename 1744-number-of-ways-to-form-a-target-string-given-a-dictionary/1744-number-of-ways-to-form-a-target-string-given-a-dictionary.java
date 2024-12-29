class Solution
{
    static int mod = 1_000_000_007;
    public int numWays(String[] w, String p)
    {
        int n = w.length, m = w[0].length(), a[][] = new int[m][26];
        for(String x: w)
            for(int i = 0; i < m; i++)
                a[i][x.charAt(i) - 'a']++;
        int dp[][] = new int[m][p.length()];
        for(int[] x: dp)
            Arrays.fill(x, -1);
        return calc(0, 0, p, a, dp);
    }
    int calc(int i, int j, String p, int a[][], int dp[][])
    {
        if(j == p.length())
            return 1;
        if(i == a.length)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = ((int)(1L * a[i][p.charAt(j) - 'a'] * calc(i + 1, j + 1, p, a, dp) % mod) + calc(i + 1, j, p, a, dp)) % mod;
    }
}