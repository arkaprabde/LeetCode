class Solution
{
    public int numEquivDominoPairs(int[][] a)
    {
        HashMap<String, Integer> mp=new HashMap<>();
        for(int x[]: a)
        {
            String s=Math.min(x[0], x[1])+" "+Math.max(x[0],x[1]);
            mp.put(s, mp.getOrDefault(s,0)+1);
        }
        int c=0;
        for(int x: mp.values())
            c+=x*(x-1)/2;
        return c;
    }
}