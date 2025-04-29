class Solution
{
    public long countSubarrays(int[] nums, int k)
    {
        long c=0;
        int mx=Arrays.stream(nums).max().getAsInt(),s=0;
        for(int l=0,r=0; r<nums.length;r++)
        {
            if(nums[r]==mx)
                s++;
            while(s>=k)
            {
                if(nums[l++]==mx)
                    s--;
            }
            c+=l;
        }
        return c;
    }
}