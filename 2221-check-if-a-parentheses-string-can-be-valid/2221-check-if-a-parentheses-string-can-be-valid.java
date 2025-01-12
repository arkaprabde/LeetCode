class Solution
{
    public boolean canBeValid(String s, String l)
    {
        int c = 0, v = 0, n = s.length();
        if((n & 1) == 1)
            return false;
        for(int i = 0; i < n; i++)
        {
            if(l.charAt(i) == '0')
                v++;
            else if(s.charAt(i) == '(')
                c++;
            else
            {
                if(c > 0)
                    c--;
                else if(v > 0)
                    v--;
                else
                    return false;
            }
        }
        c = 0;
        v = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            if(l.charAt(i) == '0')
                v++;
            else if(s.charAt(i) == ')')
                c++;
            else
            {
                if(c > 0)
                    c--;
                else if(v > 0)
                    v--;
                else
                    return false;
            }
        }
        return true;
    }
}