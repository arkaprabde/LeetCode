class Solution
{
    public int minOperations(int[] a, int k)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int x: a)
            if(x < k)
                pq.add((long)x);
        int s = 0;
        while(!pq.isEmpty())
        {
            s++;
            if(pq.size() < 2)
                break;
            long x = 2L * pq.poll() + pq.poll();
            if(x < k)
                pq.add(x);
        }
        return s;
    }
}