class Solution
{
    public List<Integer> eventualSafeNodes(int[][] a)
    {
        int n = a.length;
        boolean v[] = new boolean[n], b[] = new boolean[n];
        for(int i = 0; i < n; i++)
            if(!v[i])
                dfs(a, i, v, b);
        List<Integer> s = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(!b[i])
                s.add(i);
        return s;
    }

    boolean dfs(int a[][], int i, boolean v[], boolean b[])
    {
        v[i] = b[i] = true;
        for(int x: a[i])
            if((!v[x] && dfs(a, x, v, b)) || b[x])
                return true;
        return b[i] = false;
    }
}