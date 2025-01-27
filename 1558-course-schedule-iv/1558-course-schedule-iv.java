class Solution
{
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] b) {
        List<List<Integer>> a = new ArrayList<>();
        int[] c = new int[n];
        for(int i = 0; i < n; i++)
            a.add(new ArrayList<>());
        for(int[] x : p)
        {
            a.get(x[0]).add(x[1]);
            c[x[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(c[i] == 0)
                q.offer(i);       
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++)
            mp.put(i, new HashSet<>());
        while(!q.isEmpty())
        {
            int x = q.poll();
            for(int y : a.get(x))
            {
                mp.get(y).add(x);
                mp.get(y).addAll(mp.get(x));
                c[y]--;
                if(c[y] == 0)
                    q.offer(y);
            }
        }
        List<Boolean> s = new ArrayList<>();
        for(int[] x : b)
            s.add(mp.get(x[1]).contains(x[0]));
        return s;
    }
}