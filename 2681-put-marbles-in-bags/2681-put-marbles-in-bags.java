class Solution
{
    public long putMarbles(int[] a, int k)
    {
        int n=a.length, b[]=new int[n-1];
        for(int i=0;i<n-1;i++)
            b[i]=a[i]+a[i+1];
        Arrays.sort(b);
        long s=0L;
        for(int i=0;i<k-1;i++)
            s+=b[n-2-i]-b[i];
        return s;
    }
}