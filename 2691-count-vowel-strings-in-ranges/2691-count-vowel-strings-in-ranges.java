class Solution
{
    public int[] vowelStrings(String[] w, int[][] q)
    {
        int n = w.length, a[] = new int[n], m = q.length, s[] = new int[m];
        a[0] = check(w[0]);
        for(int i = 1; i < n; i++)
            a[i] = a[i - 1] + check(w[i]);
        for(int i = 0; i < m; i++)
            s[i] = a[q[i][1]] - (q[i][0] > 0? a[q[i][0] - 1]: 0);
        return s;
    }
    int check(String s)
    {
        String v = "AEIOIUaeiou";
        if(v.indexOf(s.charAt(0)) > 0 && v.indexOf(s.charAt(s.length() - 1)) > 0)
            return 1;
        return 0;
    }
}