class Solution
{
    public int numEquivDominoPairs(int[][] a)
    {
        int f[]=new int[100];
        for(int x[]: a)
        {
            int s=x[0]*10+x[1];
            if(x[0]>x[1])
                s=x[1]*10+x[0];
            f[s]++;
        }
        int c=0;
        for(int x: f)
            if(x>0)
                c+=x*(x-1)/2;
        return c;
    }
}