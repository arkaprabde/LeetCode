class Solution
{
    public boolean canConstruct(String s, int k)
    {
        if(s.length() < k)
            return false;
        if(s.length() == k)
            return true;
        int a[] = new int[26], v = 0;
        for(char c: s.toCharArray())
            a[c - 'a']++;
        for(int x: a)
            v += x % 2;
        return v <= k;
    }
}