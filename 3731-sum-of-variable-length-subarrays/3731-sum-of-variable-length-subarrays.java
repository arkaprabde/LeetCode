class Solution
{
    public int subarraySum(int a[])
    {
        int n = a.length, p[] = new int[n];
        p[0] = a[0];
        for(int i = 1; i < n; i++)
            p[i] = p[i - 1] + a[i];
        int s = 0;
        for(int i = 0; i < n; i++)
        {
            if(i - a[i] <= 0)
                s += p[i];
            else
                s += p[i] - p[i - a[i] - 1];
        }
        return s;
    }
}