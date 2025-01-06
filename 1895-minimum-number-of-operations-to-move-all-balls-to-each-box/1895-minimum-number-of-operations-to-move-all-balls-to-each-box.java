class Solution
{
    public int[] minOperations(String s)
    {
        int n = s.length(), a[] = new int[n], b[] = new int[n], c = (s.charAt(0) == '1')? 1: 0;
        for(int i = 1; i < n; i++)
        {
            a[i] = a[i - 1] + c;
            c += (s.charAt(i) == '1')? 1: 0;
        }
        c = (s.charAt(n - 1) == '1')? 1: 0;
        for(int i = n - 2; i >= 0; i--)
        {
            b[i] = b[i + 1] + c;
            c += (s.charAt(i) == '1')? 1: 0;
        }
        for(int i = 0; i < n; i++)
            a[i] += b[i];
        return a;
    }
}