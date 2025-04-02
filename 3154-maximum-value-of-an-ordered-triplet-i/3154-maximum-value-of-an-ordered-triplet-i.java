class Solution
{
    public long maximumTripletValue(int[] a)
    {
        long s=0L,dmx=0L,mx=0L;
        for(int x:a)
        {
            s=Math.max(s,dmx*x);
            dmx=Math.max(dmx,mx-x);
            mx=Math.max(mx,x);
        }
        return s;
    }
}