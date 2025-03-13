class Solution
{
    public int minZeroArray(int[] nums, int[][] queries)
    {
        int n = nums.length;
        int sum = 0, queryCount = 0;
        int[] diffArray = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            while (sum + diffArray[i] < nums[i])
            {
                queryCount++;
                if (queryCount > queries.length)
                    return -1;
                int left = queries[queryCount - 1][0], right = queries[queryCount - 1][1], value = queries[queryCount - 1][2];
                if (right >= i)
                {
                    diffArray[Math.max(left, i)] += value;
                    if (right + 1 < diffArray.length)
                        diffArray[right + 1] -= value;
                }
            }
            sum += diffArray[i];
        }
        return queryCount;
    }
}