class Solution
{
    public List<String> wordSubsets(String[] words1, String[] words2)
    {
        int a[] = new int[26];
        for(String w: words2)
        {
            int b[] = new int[26];
            for(char x: w.toCharArray())
                b[x - 'a']++;
            for(int i = 0; i < 26; i++)
                a[i] = Math.max(a[i], b[i]);
        }
        List<String> l = new ArrayList<>();
        for(String w: words1)
        {
            int b[] = new int[26];
            for(int x: w.toCharArray())
                b[x - 'a']++;
            int i;
            for(i = 0; i < 26; i++)
                if(a[i] > b[i])
                    break;
            if(i == 26)
                l.add(w);
        }
        return l;
    }
}