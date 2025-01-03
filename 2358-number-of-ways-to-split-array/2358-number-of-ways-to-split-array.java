class Solution
{
    public int waysToSplitArray(int[] a)
    {
        int n = a.length;
        long s[] = new long[n];
        s[0] = a[0];
        for(int i = 1; i < n; i++)
            s[i] = s[i - 1] + a[i];
        int c = 0;
        for(int i = 0; i < n -1; i++)
            if(2 * s[i] >= s[n - 1])
                c++;
        return c;
    }
}