class Solution
{
    public String shiftingLetters(String s, int[][] a)
    {
        int n = s.length(), d[] = new int[n + 1];
        for(int[] x: a)
        {
            d[x[0]]+= (x[2] == 1)? 1: -1;
            d[x[1] + 1] -= (x[2] == 1)? 1: -1;
        }
        int c = 0;
        for(int i = 0; i <= n; i++)
        {
            c += d[i];
            d[i] = c;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            int x = (d[i] % 26 + 26) % 26;
            sb.append((char)('a' + (s.charAt(i) - 'a' + x) % 26));
        }
        return sb.toString();
    }
}