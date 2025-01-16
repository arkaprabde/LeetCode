class Solution
{
    public int xorAllNums(int[] n1, int[] n2)
    {
        return (xor(n1) * (n2.length & 1)) ^ (xor(n2) * (n1.length & 1));
    }

    int xor(int a[])
    {
        int c = 0;
        for(int x: a)
            c ^= x;
        return c;
    }
}