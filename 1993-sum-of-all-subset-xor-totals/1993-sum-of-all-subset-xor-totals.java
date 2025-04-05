class Solution
{
    public int subsetXORSum(int[] nums)
    {
        return calc(nums, 0, 0);
    }
    int calc(int a[], int i, int s)
    {
        if(i==a.length)
            return s;
        return calc(a,i+1,s)+calc(a,i+1,s^a[i]);
    }
}