class Solution
{
    static final int d[] = {-1, 0, 1, 0, -1};
    public int trapRainWater(int[][] a)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[2] - y[2]));
        int n = a.length, m = a[0].length;
        boolean b[][] = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {
            pq.add(new int[]{i, 0, a[i][0]});
            pq.add(new int[]{i, m - 1, a[i][m - 1]});
            b[i][0] = b[i][m - 1] = true;
        }
        for(int i = 0; i < m; i++)
        {
            pq.add(new int[]{0, i, a[0][i]});
            pq.add(new int[]{n - 1, i, a[n - 1][i]});
            b[0][i] = b[n - 1][i] = true;
        }
        int c = 0;
        while(!pq.isEmpty())
        {
            int x[] = pq.poll();
            for(int i = 0; i < 4; i++)
            {
                int nx = x[0] + d[i], ny = x[1] + d[i + 1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || b[nx][ny])
                    continue;
                c += Math.max(0, x[2] - a[nx][ny]);
                pq.add(new int[]{nx, ny, Math.max(x[2], a[nx][ny])});
                b[nx][ny] = true;
            }
        }
        return c;
    }
}