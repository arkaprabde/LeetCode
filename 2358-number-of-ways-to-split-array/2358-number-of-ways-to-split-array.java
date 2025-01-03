class Solution
{
    public int waysToSplitArray(int[] a)
    {
        int n = a.length, c = 0;
        long s = 0, v = 0;
        for(int x: a)
            s += x;
        for(int i = 0; i < n - 1; i++)
        {
            v += a[i];
            if(v >= s - v)
                c++;
        }
        return c;
    }
}