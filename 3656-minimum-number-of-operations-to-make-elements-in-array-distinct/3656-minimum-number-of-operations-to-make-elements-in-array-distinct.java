class Solution
{
    public int minimumOperations(int[] a)
    {
        int b[] = new int[101];
        int i;
        for(i = a.length - 1; i >= 0; i--)
        {
            if(b[a[i]] > 0)
                break;
            b[a[i]]++;
        }
        return (i < 0)? 0: i / 3 + 1;
    }
}