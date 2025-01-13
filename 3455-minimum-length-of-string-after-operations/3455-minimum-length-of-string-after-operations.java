class Solution {
    public int minimumLength(String s) {
        int a[] = new int[26], c = 0;
        for(char x: s.toCharArray())
            a[x - 'a']++;
        for(int x: a)
            if(x == 0)
                continue;
            else if(x % 2 == 0)
                c += 2;
            else
                c++;
        return c;
    }
}