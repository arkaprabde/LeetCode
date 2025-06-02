class Solution
{
    public int candy(int[] a)
    {
        int n=a.length, b[]=new int[n];
        b[0]=1;
        for(int i=1;i<n;i++)
            if(a[i]>a[i-1])
                b[i]=b[i-1]+1;
            else
                b[i]=1;
        for(int i=n-2;i>=0;i--)
            if(a[i]>a[i+1] && b[i]<=b[i+1])
                b[i]=b[i+1]+1;
        return Arrays.stream(b).sum();
    }
}