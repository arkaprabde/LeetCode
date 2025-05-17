class Solution
{
    public void sortColors(int a[])
    {
        int s[] = new int[3], c = 0;
        Arrays.fill(s, 0);
        for(int x: a)
            s[x]++;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < s[i]; j++)
                a[c++] = i;
    }
}