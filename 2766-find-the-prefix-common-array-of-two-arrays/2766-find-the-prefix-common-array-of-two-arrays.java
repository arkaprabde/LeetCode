class Solution
{
    public int[] findThePrefixCommonArray(int[] a, int[] b)
    {
        int n = a.length, s = 0;
        int[] c = new int[n], t = new int[n + 1];
        for(int i = 0; i < n; i++)
        {
            if(++t[a[i]] == 2)
                s++;
            if(++t[b[i]] == 2)
                s++;
            c[i] = s;
        }
        return c;
    }
}