class Solution
{
    int d[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minCost(int[][] a)
    {
        int m = a.length, n = a[0].length;
        boolean v[][] = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        pq.add(new int[]{0, 0, 0});
        while(!pq.isEmpty())
        {
            int x[] = pq.poll();
            if(v[x[0]][x[1]])
                continue;
            v[x[0]][x[1]] = true;
            if(x[0] == m - 1 && x[1] == n - 1)
                return x[2];
            for(int p = 0; p < 4; p++)
            {
                int c = 1;
                if(p == a[x[0]][x[1]] - 1)
                    c = 0;
                int nx = x[0] + d[p][0], ny = x[1] + d[p][1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || v[nx][ny])
                    continue;
                pq.add(new int[]{nx, ny, x[2] + c});
            }
        }
        return -1;
    }
}