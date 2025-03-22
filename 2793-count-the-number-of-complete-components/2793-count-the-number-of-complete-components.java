class Solution
{
    public int countCompleteComponents(int n, int[][] e)
    {
        List<Integer>[] a=new ArrayList[n];
        for(int i=0;i<n;i++)
            a[i]=new ArrayList<>();
        for(int x[]: e)
        {
            a[x[0]].add(x[1]);
            a[x[1]].add(x[0]);
        }
        int u=0,c=0;
        boolean b[]=new boolean[n];
        while(true)
        {
            while(u<n && b[u]) u++;
            if(u==n) break;
            Queue<Integer> q=new LinkedList<>();
            List<Integer> l=new ArrayList<>();
            q.add(u);
            b[u]=true;
            while(!q.isEmpty())
            {
                int x=q.poll();
                l.add(x);
                for(int y:a[x])
                    if(!b[y])
                    {
                        q.add(y);
                        b[y]=true;
                    }
            }
            boolean f=true;
            for(int x: l)
                if(a[x].size()!=l.size()-1)
                {
                    f=false;
                    break;
                }
            if(f) c++;
        }
        return c;
    }
}