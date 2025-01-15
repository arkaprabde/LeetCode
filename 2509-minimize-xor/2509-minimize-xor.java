class Solution
{
    public int minimizeXor(int n1, int n2)
    {
        int s = count(n1), v = count(n2);
        while(s > v)
        {
            n1 = n1 & (n1 - 1);
            s--;
        }
        while(v > s)
        {
            n1 = n1 | (n1 + 1);
            v--;
        }
        return n1;
    }
    int count(int n)
    {
        int s = 0;
        while(n > 0)
        {
            s += (n & 1);
            n = n >> 1;
        }
        return s;
    }
}