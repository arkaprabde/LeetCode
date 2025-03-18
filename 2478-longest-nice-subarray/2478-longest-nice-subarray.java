class Solution
{
    public int longestNiceSubarray(int[] a)
    {
        /*
        int mx=1;
        for(int l=0,h=0;h<a.length;h++)
        {
            mx=Math.max(mx,h-l);
            int i=l;
            for(;i<h;i++)
                if((a[i]&a[h])!=0)
                    break;
            //System.out.println(l+" "+h+" "+i);
            if(i<h)
                l=i+1;
        }
        return mx;
        */
        int mx=1,s=0;
        for(int l=0,h=0;h<a.length;h++)
        {
            while((s&a[h])!=0)
                s-=a[l++];
            s+=a[h];
            mx=Math.max(mx,h-l+1);
        }
        return mx;
    }
}