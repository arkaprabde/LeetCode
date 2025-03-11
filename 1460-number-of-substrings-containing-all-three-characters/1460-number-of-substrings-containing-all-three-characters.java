class Solution
{
    public int numberOfSubstrings(String s)
    {
        int a[]=new int[3], c=0;
        char ch[]=s.toCharArray();
        int n=ch.length;
        for(int l=0,h=0;h<n;h++)
        {
            a[ch[h]-'a']++;
            while(a[0]>0 && a[1]>0 && a[2]>0)
            {
                c+=n-h;
                a[ch[l++]-'a']--;
            }
        }
        return c;
    }
}