class Solution
{
    public int maxScore(String s)
    {
        int n = s.length(), a[] = new int[n], b[] = new int[n], mx = 0;
        a[0] = (s.charAt(0) == '0'? 1: 0);
        for(int i = 1; i < n; i++)
            if(s.charAt(i) == '0')
                a[i] = a[i - 1] + 1;
            else
                a[i] = a[i - 1];
        b[n - 1] = (s.charAt(n - 1) == '0'? 0: 1);
        for(int i = n - 2; i >= 0; i--)
            if(s.charAt(i) == '1')
                b[i] = b[i + 1] + 1;
            else
                b[i] = b[i + 1];
        mx = a[0] + b[1];
        for(int i = 1; i < n - 1; i++)
            mx = Math.max(mx, a[i] + b[i + 1]);
        return mx;
    }
}