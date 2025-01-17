class Solution
{
    public boolean doesValidArrayExist(int[] derived)
    {
        int count = 0;
        for(int element: derived)
            count += element;
        return (count & 1) == 0;
    }
}