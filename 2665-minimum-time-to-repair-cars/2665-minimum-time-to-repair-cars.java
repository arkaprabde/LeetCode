class Solution
{
    public long repairCars(int a[], int c)
    {
        long l=1;
        for(long r=(long)Arrays.stream(a).min().getAsInt()*c*c;l<r;)
        {
            long m=l+(r-l)/2;
            if(check(a,c,m))
                r=m;
            else
                l=m+1;
        }
        return l;
    }

    boolean check(int a[],int c,long t)
    {
        long s=0;
        for(int x:a)
        {
            s+=Math.sqrt(t/x);
            if(s>=c)
                return true;
        }
        return false;
    }
}