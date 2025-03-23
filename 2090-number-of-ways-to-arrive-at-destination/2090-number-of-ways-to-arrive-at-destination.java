class Solution
{
    public int countPaths(int n, int[][] roads)
    {
        List<int[]>[] a=new ArrayList[n];
        for(int i=0;i<n;i++)
            a[i]=new ArrayList<>();
        for(int x[]:roads)
        {
            a[x[0]].add(new int[]{x[1],x[2]});
            a[x[1]].add(new int[]{x[0],x[2]});
        }
        long d[]=new long[n];
        int s[]=new int[n];
        Arrays.fill(d,Long.MAX_VALUE);
        d[0]=0;
        s[0]=1;
        PriorityQueue<long[]> pq=new PriorityQueue<>((x,y)->(int)(x[1]-y[1]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty())
        {
            long x[]=pq.poll();
            int nx=(int)x[0];
            if(x[1]>d[nx])
                continue;
            for(int y[]: a[nx])
            {
                int ny=y[0],t=y[1];
                if(d[nx]+t<d[ny])
                {
                    d[ny]=d[nx]+t;
                    s[ny]=s[nx];
                    pq.offer(new long[]{ny,d[ny]});
                }
                else if(d[nx]+t==d[ny])
                    s[ny]=(s[ny]+s[nx])%1_000_000_007;
            }
        }
        return s[n-1];
    }
}