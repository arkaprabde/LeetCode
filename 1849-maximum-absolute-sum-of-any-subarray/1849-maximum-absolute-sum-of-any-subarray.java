class Solution
{
    public int maxAbsoluteSum(int[] a)
    {
        int mn = 0, s = 0, mx = 0;
        for(int x: a)
        {
            s += x;
            mx = Math.max(mx, s);
            mn = Math.min(mn, s);
        }
        return Math.abs(mx - mn);
    }
}