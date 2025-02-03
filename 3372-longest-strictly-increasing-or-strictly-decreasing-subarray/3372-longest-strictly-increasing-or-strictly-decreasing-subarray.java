class Solution
{
    public int longestMonotonicSubarray(int[] a)
    {
        if(a.length < 2)
            return a.length;
        int mx = 1, l1 = 1, l2 = 1;
        for(int i = 1; i < a.length; i++)
        {
            if(a[i] < a[i - 1])
            {
                l1++;
                l2 = 1;
            }
            else if(a[i] > a[i - 1])
            {
                l2++;
                l1 = 1;
            }
            else
                l1 = l2 = 1;
            mx = Math.max(mx, Math.max(l1, l2));
        }
        return mx;
    }
}