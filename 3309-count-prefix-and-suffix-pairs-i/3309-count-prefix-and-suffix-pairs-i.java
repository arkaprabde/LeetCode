class Solution
{
    public int countPrefixSuffixPairs(String[] w)
    {
        int n = w.length, s = 0;
        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
                if(w[j].startsWith(w[i]) && w[j].endsWith(w[i]))
                    s++;
        return s;
    }
}