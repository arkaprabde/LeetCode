class Solution
{
    public int minimumOperations(int[] a)
    {
        int mp[]=new int[101];
        for(int i=a.length-1;i>=0;i--)
            if(mp[a[i]]++>0)
                return (i+3)/3;
        return 0;
    }
}