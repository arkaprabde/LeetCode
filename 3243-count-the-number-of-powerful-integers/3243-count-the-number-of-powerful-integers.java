class Solution
{
    public long numberOfPowerfulInt(long start, long finish, int limit, String s)
    {
        String startStr = Long.toString(start - 1);
        String finishStr = Long.toString(finish);
        return calculate(finishStr, s, limit) - calculate(startStr, s, limit);
    }
    private long calculate(String x, String s, int limit)
    {
        if (x.length() < s.length())
            return 0;
        if (x.length() == s.length())
            return x.compareTo(s) >= 0 ? 1 : 0;
        for (char c : s.toCharArray())
            if (c - '0' > limit) return 0;
        long count = 0;
        int prefixLen = x.length() - s.length();
        boolean tight = true;
        for (int i = 0; i < prefixLen; i++)
        {
            int maxDigit = tight ? (x.charAt(i) - '0') : limit;
            for (int d = 0; d <= Math.min(limit, maxDigit - 1); d++)
                count += (long) Math.pow(limit + 1, prefixLen - 1 - i);
            if ((x.charAt(i) - '0') > limit)
                return count;
            if ((x.charAt(i) - '0') < maxDigit)
                tight = false;
        }
        String candidate = x.substring(0, prefixLen) + s;
        if (candidate.compareTo(x) <= 0)
            count++;
        return count;
    }
}