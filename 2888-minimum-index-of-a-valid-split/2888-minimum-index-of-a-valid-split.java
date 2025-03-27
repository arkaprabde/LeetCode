class Solution
{
    public int minimumIndex(List<Integer> nums)
    {
        Map<Integer,Integer> mp=new HashMap<>(),m=new HashMap<>();
        int n=nums.size();
        for(int x:nums)
            mp.put(x,mp.getOrDefault(x,0)+1);
        int i=0;
        for(i=0;i<n;i++)
        {
            int x=nums.get(i);
            m.put(x,m.getOrDefault(x,0)+1);
            if(m.get(x)>(i+1)/2 && mp.get(x)-m.get(x)>(n-i-1)/2)
                break;
        }
        return (i==n)?-1:i;
    }
}