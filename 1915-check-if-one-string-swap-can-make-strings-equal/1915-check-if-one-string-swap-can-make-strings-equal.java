class Solution
{
    public boolean areAlmostEqual(String s1, String s2)
    {
        int s = -1, v = 0;
        for(int i = 0; i < s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
            {
                v++;
                if(s > -1 && (s2.charAt(i) != s1.charAt(s) || s1.charAt(i) != s2.charAt(s)))
                    return false;
                s = i;
            }
        return v == 2 || v == 0;
    }
}