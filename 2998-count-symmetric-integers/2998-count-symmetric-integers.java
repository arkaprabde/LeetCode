class Solution
{
    public int countSymmetricIntegers(int low, int high)
    {
        int c=0;
        for(int x=low;x<=high;x++)
            c+=check(x);
        return c;
    }
    int check(int x)
    {
        int n=(""+x).length();
        if((n & 1)==1)
            return 0;
        n>>=1;
        int s=0,c=0;
        while(x>0)
        {
            int d=x%10;
            if(c++<n)
                s+=d;
            else
                s-=d;
            x/=10;
        }
        return (s==0)?1:0;
    }
}