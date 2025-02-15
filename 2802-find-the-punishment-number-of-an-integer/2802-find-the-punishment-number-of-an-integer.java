class Solution
{
    public int punishmentNumber(int n)
    {
        int s = 0;
        for(int i = 1; i <= n; i++)
            if(check(String.valueOf(i * i), 0, i))
                s += (i * i);
        return s;
    }

    boolean check(String n, int i, int s)
    {
        if(i == n.length())
            return s == 0;
        int v = 0;
        for(; i < n.length(); i++)
        {
            v = v * 10 + (n.charAt(i) - '0');
            if(v > s)
                break;
            if(check(n, i + 1, s - v))
                return true;
        }
        return false;
    }
}