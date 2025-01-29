class Solution
{
    public int[] findRedundantConnection(int[][] e)
    {
        UnionFind uf = new UnionFind(e.length);
        for (int[] x : e)
        {
            int x1 = uf.find(x[0] - 1);
            int x2 = uf.find(x[1] - 1);
            if (x1 == x2)
                return new int[] {x[0], x[1]};
            else
                uf.union(x1, x2);
        }
        return null;
    }
    static class UnionFind
    {
        private final int[] parent, rank;
        public UnionFind(int size)
        {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x)
        {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y)
        {
            int rootX = find(x), rootY = find(y);
            if (rootX != rootY)
            {
                if(rank[rootX] > rank[rootY])
                    parent[rootY] = rootX;
                else if(rank[rootX] < rank[rootY])
                    parent[rootX] = rootY;
                else
                    parent[rootY] = rootX;
                    rank[rootX]++;
            }
        }
    }
}