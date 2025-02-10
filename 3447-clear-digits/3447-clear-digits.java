class Solution
{
    public String clearDigits(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(char x: s.toCharArray())
            if(Character.isDigit(x))
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(x);
        return sb.toString();
    }
}