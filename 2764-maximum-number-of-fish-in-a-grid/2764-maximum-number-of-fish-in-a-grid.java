class Solution
{
    static int d[] = {-1, 0, 1, 0, -1};
    public int findMaxFish(int[][] a)
    {
        int mx = 0;
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[0].length; j++)
                if(a[i][j] != 0)
                    mx = Math.max(mx, dfs(a, i, j));
        return mx;
    }
    int dfs(int a[][], int x, int y)
    {
        if(x < 0 || y < 0 || x >= a.length || y >= a[0].length || a[x][y] == 0)
            return 0;
        int s = a[x][y];
        a[x][y] = 0;
        for(int i = 0; i < 4; i++)
            s += dfs(a, x + d[i], y + d[i + 1]);
        return s;
    }
}