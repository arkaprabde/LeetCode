class Solution
{
    public boolean checkValidCuts(int n, int[][] a)
    {
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        if(check(a,0,2))
            return true;
        Arrays.sort(a,(x,y)->x[1]-y[1]);
        return check(a,1,3);
    }

    boolean check(int a[][],int p,int q)
    {
        int c=0,i=0,n=a.length;
        while(i<n)
        {
            int x=a[i][q];
            while(i<n && a[i][p]<x)
                x=Math.max(a[i++][q],x);
            c++;
        }
        return c>2;
    }
}