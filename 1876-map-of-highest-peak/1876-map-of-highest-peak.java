class Solution
{
    static final int d[] = {-1, 0, 1, 0, -1};
    public int[][] highestPeak(int[][] a)
    {
        int n = a.length, m = a[0].length, b[][] = new int[n][m];
        boolean v[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(a[i][j] == 1)
                {
                    b[i][j] = 0;
                    q.add(new int[]{i, j, 0});
                    v[i][j] = true;
                }
        while(!q.isEmpty())
        {
            int x[] = q.poll();
            for(int p = 0; p < 4; p++)
            {
                int nx = x[0] + d[p], ny = x[1] + d[p + 1], nh = x[2] + 1;
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !v[nx][ny])
                {
                    b[nx][ny] = nh;
                    v[nx][ny] = true;
                    q.add(new int[]{nx, ny, nh});
                }
            }
        }
        return b;
    }
}