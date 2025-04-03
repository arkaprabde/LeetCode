class Solution
{
    public long maximumTripletValue(int[] nums)
    {
        long s=0,mx=0,p=0;
        for(int x:nums)
        {
            s=Math.max(x*p,s);
            p=Math.max(p,mx-x);
            mx=Math.max(mx,x);
        }
        return (s<0)?0:s;
    }
}