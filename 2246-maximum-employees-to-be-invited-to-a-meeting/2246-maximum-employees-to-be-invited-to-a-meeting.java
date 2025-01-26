class Solution
{
    public static int maximumInvitations(int[] a)
    {
        int n = a.length, b[] = new int[n], q[] = new int[n], c[] = new int[n], l = 0, r = 0, s = 0, v = 0;
        for(int i = 0; i < n; i++)
            b[a[i]]++;
        for(int i = 0; i < n; i++)
            if(b[i] == 0)
                q[r++] = i;
        while(l < r)
        {
            int x = q[l++], y = a[x];
            c[y] = Math.max(c[y], c[x] + 1);
            if(--b[y] == 0)
                q[r++] = y;
        }
        for(int i = 0; i < n; i++)
        {
            if(b[i] != 0)
            {
                b[i] = 0;
                int p = 1;
                for (int j = a[i]; j != i; j = a[j])
                {
                    p++;
                    b[j] = 0;
                }
                if(p == 2)
                    s += c[i] + c[a[i]] + 2;
                else
                    v = Math.max(v, p);
            }
        }
        return Math.max(v, s);
    }
}