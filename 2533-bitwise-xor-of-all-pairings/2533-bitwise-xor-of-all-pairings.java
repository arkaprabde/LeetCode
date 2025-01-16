class Solution
{
    public int xorAllNums(int[] n1, int[] n2)
    {
        if(n1.length % 2 != 0 && n2.length % 2 != 0)
            return xor(n1) ^ xor(n2);
        else if(n1.length % 2 != 0)
            return xor(n2);
        else if(n2.length % 2 != 0)
            return xor(n1);
        else
            return 0;

    }

    int xor(int a[])
    {
        int c = 0;
        for(int x: a)
            c ^= x;
        return c;
    }
}