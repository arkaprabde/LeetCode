class Solution
{
    public int xorAllNums(int[] n1, int[] n2)
    {
        int x = n1.length & 1, y = n2.length & 1;
        if(x == 1 && y == 1)
            return xor(n1) ^ xor(n2);
        else if(x == 1)
            return xor(n2);
        else if(y == 1)
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