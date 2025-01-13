class Solution
{
    public int maximumAmount(int[][] a)
    {
        int dp[][][] = new int[a.length][a[0].length][3];
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[i].length; j++)
            Arrays.fill(dp[i][j], Integer.MIN_VALUE);
        return calc(a, dp, 0, 0, 2);
    }
    int calc(int a[][], int dp[][][], int x, int y, int z)
    {
        if(x >= a.length || y >= a[0].length)
            return Integer.MIN_VALUE;
        if(x == a.length - 1 && y == a[0].length - 1)
            return z > 0? Math.max(0, a[x][y]): a[x][y];
        if(dp[x][y][z] != Integer.MIN_VALUE)
            return dp[x][y][z];
        int m1 = a[x][y] + Math.max(calc(a, dp, x + 1, y, z), calc(a, dp, x, y + 1, z)), m2 = Integer.MIN_VALUE;
        if(a[x][y] < 0 && z > 0)
            m2 = Math.max(calc(a, dp, x + 1, y, z - 1), calc(a, dp, x, y + 1, z - 1));
        return dp[x][y][z] = Math.max(m1, m2);
    }
}