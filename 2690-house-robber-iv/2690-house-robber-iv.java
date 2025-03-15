class Solution
{
    boolean check(int a[], int k, int s)
    {
        int c=0;
        for(int i=0;i<a.length;i++)
            if(a[i]<=s)
            {
                c++;
                i++;
            }
        return c>=k;
    }
    public int minCapability(int[] a, int k)
    {
        int l=Arrays.stream(a).min().getAsInt(),r=Arrays.stream(a).max().getAsInt();
        while(l<r)
        {
            int m=l+(r-l)/2;
            if(check(a,k,m))
                r=m;
            else
                l=m+1;
        }
        return l;
    }
}