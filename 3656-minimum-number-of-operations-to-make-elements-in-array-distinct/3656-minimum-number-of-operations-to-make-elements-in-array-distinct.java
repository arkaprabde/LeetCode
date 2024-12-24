class Solution
{
    public int minimumOperations(int[] a)
    {
        Set<Integer> st = new HashSet<>();
        int i;
        for(i = a.length - 1; i >= 0; i--)
        {
            if(st.contains(a[i]))
                break;
            st.add(a[i]);
        }
        i++;
        return (i / 3) + (i % 3 == 0? 0: 1);
    }
}