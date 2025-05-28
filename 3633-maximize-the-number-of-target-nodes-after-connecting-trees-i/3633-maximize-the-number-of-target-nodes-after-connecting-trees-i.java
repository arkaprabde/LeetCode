class Solution {
    public int[] maxTargetNodes(int[][] e1, int[][] e2, int k)
    {
        Map<Integer, List<Integer>> mp1 = adj(e1), mp2 = adj(e2);
        int a[] = new int[mp1.size()], p = 0;
        for(int x: mp1.keySet())
            a[x] = count(x, mp1, k);
        int mx = 0;
        for(int x: mp2.keySet())
            mx = Math.max(mx, count(x, mp2, k - 1));
        for(int i = 0; i < a.length; i++)
            a[i] += mx;
        return a;
    }

    Map<Integer, List<Integer>> adj(int[][] a)
    {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] x : a)
        {
            mp.putIfAbsent(x[0], new ArrayList<>());
            mp.get(x[0]).add(x[1]);
            mp.putIfAbsent(x[1], new ArrayList<>());
            mp.get(x[1]).add(x[0]);
        }
        return mp;
    }

    int count(int u, Map<Integer, List<Integer>> mp, int k)
    {
        int c = 0;
        boolean v[] = new boolean[mp.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        v[u] = true;
        while(!q.isEmpty() && k-- > -1)
        {
            int s = q.size();
            c += s;
            while(s-- > 0)
            {
                int x = q.poll();
                for(int y: mp.get(x))
                {
                    if(v[y])
                        continue;
                    v[y] = true;
                    q.add(y);
                }
            }
        }
        return c;
    }
}

