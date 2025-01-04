class Solution
{
    public int countPalindromicSubsequence(String s)
    {
        int a[] = new int[26], b[] = new int[26], c = 0, n = s.length();
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        for(int i = 0; i < n; i++)
        {
            int x = s.charAt(i) - 'a';
            if(a[x] == -1)
                a[x] = i;
            else
                b[x] = i;
        }
        for(int i = 0; i < 26; i++)
        {
            if(b[i] != -1)
            {
                Set<Character> st = new HashSet<>();
                for(int j = a[i] + 1; j < b[i]; j++)
                    st.add(s.charAt(j));
                c += st.size();
            }
        }
        return c;
    }
}