class Solution {
    public int minimumRecolors(String a, int k)
    {
        int s = 0, mn = a.length();
        for(int i = 0; i < a.length(); i++)
        {
            if(i >= k)
            {
                if(a.charAt(i - k) == 'W')
                    s--;
            }
            if(a.charAt(i) == 'W')
                s++;
            if(i >= k - 1)
            {
                mn = Math.min(mn, s);
                if(mn == 0)
                    return 0;
            }
        }
        return mn;
    }
}