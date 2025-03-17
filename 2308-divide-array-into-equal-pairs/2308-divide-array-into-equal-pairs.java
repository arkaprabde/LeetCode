class Solution
{
    public boolean divideArray(int[] a)
    {
        int f[]=new int[501];
        for(int x:a)
            f[x]++;
        for(int x:f)
            if((x&1)==1)
                return false;
        return true;
    }
}