class Solution
{
    public int maximumCount(int[] a)
    {
        int s=0,v=0;
        for(int x:a)
            if(x>0)
                s++;
            else if(x<0)
                v++;
        return (v>s)?v:s;
    }
}