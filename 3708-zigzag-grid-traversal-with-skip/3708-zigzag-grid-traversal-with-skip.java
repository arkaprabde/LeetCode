class Solution
{
    public List<Integer> zigzagTraversal(int[][] a)
    {
        List<Integer> l = new ArrayList<>();
        int f = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(i % 2 == 0)
            {
                for(int j = 0; j < a[0].length; f++, j++)
                    if(f % 2 == 0)
                        l.add(a[i][j]);
            }
            else
            {
                for(int j = a[0].length - 1; j >= 0; f++, j--)
                    if(f % 2 == 0)
                        l.add(a[i][j]);
            }
        }
        return l;
    }
}