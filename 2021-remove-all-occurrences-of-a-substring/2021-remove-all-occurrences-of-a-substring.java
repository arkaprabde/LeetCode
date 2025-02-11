class Solution
{
    public String removeOccurrences(String s, String p)
    {
        char[] chr1 = s.toCharArray(), st = new char[chr1.length], chr2 = p.toCharArray();
        int l = 0;
        for(char x: chr1)
        {
            st[l++] = x;
            if(x == chr2[chr2.length - 1] && l >= chr2.length)
            {
                int i = l - 1, j = chr2.length - 1;
                while(j >= 0 && st[i] == chr2[j])
                {
                    i--;
                    j--;
                }
                if(j < 0)
                    l = i + 1;
            }
        }
        return new String(st, 0, l);
    }
}