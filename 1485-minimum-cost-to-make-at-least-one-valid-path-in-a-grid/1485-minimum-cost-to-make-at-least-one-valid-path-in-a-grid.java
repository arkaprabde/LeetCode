class Solution
{
    static final int d[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minCost(int[][] a)
    {
        int m = a.length, n = a[0].length;
        boolean v[][] = new boolean[m][n];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0});
        while(!dq.isEmpty())
        {
            int x[] = dq.poll();
            if(v[x[0]][x[1]])
                continue;
            v[x[0]][x[1]] = true;
            if(x[0] == m - 1 && x[1] == n - 1)
                return x[2];
            for(int p = 0; p < 4; p++)
            {
                int nx = x[0] + d[p][0], ny = x[1] + d[p][1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || v[nx][ny])
                    continue;
                if(p == a[x[0]][x[1]] - 1)
                    dq.offerFirst(new int[]{nx, ny, x[2]});
                else
                    dq.offerLast(new int[]{nx, ny, x[2] + 1});
            }
        }
        return -1;
    }
}