class Solution
{
    public boolean doesValidArrayExist(int[] a)
    {
        int c = 0;
        for(int x: a)
            c += x;
        return (c & 1) == 0;
    }
}