class Solution
{
    public int maxScoreSightseeingPair(int[] a)
    {
        int m = a[0], s = Integer.MIN_VALUE;
        for(int i = 1; i < a.length; i++)
        {
            if(a[i] - i + m > s)
                s = a[i] - i + m;
            if(a[i] + i > m)
                m = a[i] + i;
        }
        return s;
    }
}