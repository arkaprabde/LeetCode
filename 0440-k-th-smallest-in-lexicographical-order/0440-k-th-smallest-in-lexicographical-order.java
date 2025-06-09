class Solution 
{
    public int findKthNumber(int n, int k) 
    {
        int x = 1;
        k--;
        while (k > 0) 
        {
            long steps = countSteps(n, x, x + 1);
            
            if (steps <= k)
            {
                k -= steps;
                x++;
            }
            else
            {
                k--;
                x *= 10;
            }
        }
        return x;
    }
    private long countSteps(int n, long curr, long next)
    {
        long steps = 0;
        while (curr <= n)
        {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
