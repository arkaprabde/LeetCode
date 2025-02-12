class Solution
{
    public int maximumSum(int[] a)
    {
        PriorityQueue<Integer>[] l = new PriorityQueue[82];
        for(int i = 0; i < 82; i++)
            l[i] = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: a)
        {
            int y = x, s = 0;
            while(y > 0)
            {
                s += y % 10;
                y /= 10;
            }
            l[s].add(x);
        }
        int mx = -1;
        for(PriorityQueue<Integer> p: l)
            if(p.size() > 1)
                mx = Math.max(mx, p.poll() + p.poll());
        return mx;
    }
}