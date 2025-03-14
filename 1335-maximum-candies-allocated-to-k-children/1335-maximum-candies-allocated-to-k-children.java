class Solution
{
    public int maximumCandies(int[] a, long k)
    {
        int l=1,r=10_000_000, s=0;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            long c=0;
            for(int x:a)
                c+=x/m;
            if(c>=k)
            {
                s=m;
                l=m+1;
            }
            else
                r=m-1;
        }
        return s;
    }
}