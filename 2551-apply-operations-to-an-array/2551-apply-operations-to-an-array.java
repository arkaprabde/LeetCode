class Solution
{
    public int[] applyOperations(int[] a)
    {
        int b[] = new int[a.length], k = 0;
        for(int i = 0; i < a.length - 1; i++)
            if(a[i] == a[i + 1] && a[i] != 0)
            {
                b[k++] =a[i] * 2;
                a[i + 1] = 0;
            }
            else if(a[i] != 0)
                b[k++] = a[i];
        b[k++] = a[a.length - 1];
        return b;
    }
}