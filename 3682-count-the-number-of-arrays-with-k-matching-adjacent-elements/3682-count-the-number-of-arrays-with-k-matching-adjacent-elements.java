class Solution
{
    static final int mod = 1_000_000_007;
    static int f[] = new int[100000];
    static boolean u = false;

    static int mul(int x, int y)
    {
        return (int) ((1L * x * y) % mod);
    }

    static int div(int x, int y)
    {
        return mul(x, mod(y));
    }

    static int mod(int x)
    {
        return pow(x, mod - 2);
    }

    static int pow(int a, int b)
    {
        int c = 1;
        while (b > 0) {
            if ((b & 1) > 0)
                c = mul(c, a);
            a = mul(a, a);
            b >>= 1;
        }
        return c;
    }

    static void facts()
    {
        if(u)
            return;
        f[0] = 1;
        for (int i = 1; i < 100000; i++)
            f[i] = mul(f[i - 1], i);
        u = true;
    }

    static int C(int n, int r)
    {
        if (r > n)
            return 0;
        return div(f[n], mul(f[r], f[n - r]));
    }

    public int countGoodArrays(int n, int m, int k)
    {
        facts();
        return mul(mul(m, pow(m - 1, n - k - 1)), C(n - 1, n - k - 1));
    }
}