class Solution
{
    public int countGoodTriplets(int[] p, int a, int b, int c)
    {
        int s=0,n=p.length;
        for(int i=0;i<n-2;i++)
            for(int j=i+1;j<n-1;j++)
                for(int k=j+1;k<n;k++)
                    if(Math.abs(p[i]-p[j])<=a && Math.abs(p[j]-p[k])<=b && Math.abs(p[k]-p[i])<=c)
                        s++;
        return s;
    }
}