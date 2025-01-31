import java.util.Set;
class Solution
{
    Set<Character>[] r = new HashSet[9], c = new HashSet[9], b = new HashSet[9];
    static final char[] ch = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public void solveSudoku(char[][] a)
    {
        int i, j;
        for(i = 0; i < 9; i++)
        {
            r[i] = new HashSet<>();
            c[i] = new HashSet<>();
            b[i] = new HashSet<>();
        }
        for(i = 0; i < 9; i++)
            for(j = 0; j < 9; j++)
                if(a[i][j] != '.')
                {
                    r[i].add(a[i][j]);
                    b[3 * (i / 3) + j / 3].add(a[i][j]);
                    c[j].add(a[i][j]);
                }
        solve(a, 0, 0);
    }

    boolean solve(char[][] a, int i, int j)
    {
        if(i == 9)
            return true;
        if(j == 9)
            return solve(a, i + 1, 0);
        if(a[i][j] != '.')
            return solve(a, i, j + 1);
        for(char x: ch)
        {
            if(!r[i].contains(x) && !c[j].contains(x) && !b[3 * (i / 3) + j / 3].contains(x))
            {
                a[i][j] = x;
                r[i].add(x);
                c[j].add(x);
                b[3 * (i / 3) + j / 3].add(x);
                if(solve(a, i, j + 1))
                    return true;
                r[i].remove(x);
                c[j].remove(x);
                b[3 * (i / 3) + j / 3].remove(x);
            }
        }
        a[i][j] = '.';
        return false;
    }
}