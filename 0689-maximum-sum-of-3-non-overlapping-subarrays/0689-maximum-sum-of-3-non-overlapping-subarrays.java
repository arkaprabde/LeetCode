class Solution
{
    public int[] maxSumOfThreeSubarrays(int[] a, int k)
    {
        int n = a.length, s1 = 0, s2 = 0, s3 = 0, mx1 = 0, mx2 = 0, mx3 = 0,  p1 = 0, p2 = 0, p3 = k, s[] = {0, k, 2 * k};
        for (int i = 0; i < k; i++)
        {
            s1 += a[i];
            s2 += a[i + k];
            s3 += a[i + 2 * k];
        }
        mx1 = s1;
        mx2 = s1 + s2;
        mx3 = s1 + s2 + s3;
        for (int i = 0; i <= n - 3 * k; i++)
        {
            if (i > 0)
            {
                s1 = s1 - a[i - 1] + a[i + k - 1];
                s2 = s2 - a[i + k - 1] + a[i + 2 * k - 1];
                s3 = s3 - a[i + 2 * k - 1] + a[i + 3 * k - 1];
            }
            if (s1 > mx1)
            {
                mx1 = s1;
                p1 = i;
            }
            if (mx1 + s2 > mx2)
            {
                mx2 = mx1 + s2;
                p2 = p1;
                p3 = i + k;
            }
            if (mx2 + s3 > mx3)
            {
                mx3 = mx2 + s3;
                s = new int[]{p2, p3, i + 2 * k};
            }
        }
        return s;
    }
}