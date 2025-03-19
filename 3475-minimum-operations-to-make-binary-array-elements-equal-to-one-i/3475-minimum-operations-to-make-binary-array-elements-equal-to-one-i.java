class Solution
{
    public int minOperations(int[] a)
    {
        int c=0;
        for(int i=0;i<a.length-2;i++)
            if(a[i]==0)
            {
                a[i+1]^=1;
                a[i+2]^=1;
                c++;
            }
        if(a[a.length-1]==0 || a[a.length-2]==0)
            return -1;
        return c;
    }
}