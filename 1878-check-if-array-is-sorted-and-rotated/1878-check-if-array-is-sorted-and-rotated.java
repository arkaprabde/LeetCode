class Solution
{
    public boolean check(int[] a)
    {
        int i = 0;
        for(i = 1; i < a.length; i++)
            if(a[i - 1] > a[i])
                break;
        if(i == a.length)
            return true;
        for(int j = (i + 1) % a.length; j != i; j = (j + 1) % a.length)
            if(a[(j - 1 + a.length) % a.length] > a[j])
                return false;
        return true;
    }
}