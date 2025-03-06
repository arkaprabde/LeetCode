class Solution
{
    public int[] findMissingAndRepeatedValues(int[][] a)
    {
        HashSet<Integer> st = new HashSet<>();
        int b[] = new int[2], s = 0, n = a.length * a.length;
        for(int p[]: a)
        {
            for(int x: p)
            {
                if(st.contains(x))
                {
                    b[0] = x;
                    continue;
                }
                s += x;
                st.add(x);
            }
        }
        b[1] = (n * (n + 1)) / 2 - s;
        return b;
    }
}