class Solution
{
    public boolean isArraySpecial(int[] a)
    {
        for(int i = 0; i < a.length - 1; i++)
            if(((a[i] + a[i + 1]) & 1) == 0)
                return false;
        return true;
    }
}