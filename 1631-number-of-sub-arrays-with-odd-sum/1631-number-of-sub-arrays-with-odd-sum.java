class Solution
{
    public int numOfSubarrays(int[] arr)
    {
        long s = 0, c = 0;
        for(int x: arr)
        {
            s += x;
            c += s % 2;
        }
        c += (arr.length - c) * c;
        return (int)(c % 1_000_000_007);
    }
}