import java.util.StringTokenizer;
class Solution
{
    public int[] countMentions(int n, List<List<String>> e)
    {
        Collections.sort(e, (x, y) -> (Integer.parseInt(x.get(1)) == Integer.parseInt(y.get(1)))? y.get(0).compareTo(x.get(0)): Integer.valueOf(x.get(1)) - Integer.valueOf(y.get(1)));
        int b[] = new int[n], c[] = new int[n], s = 0;
        for(int i = 0; i < e.size(); i++)
        {
            List<String> x = e.get(i);
            String a = x.get(0), d = x.get(2);
            int t = Integer.valueOf(x.get(1));
            if(x.get(0).equals("OFFLINE"))
            {
                b[Integer.valueOf(d)] = t + 60;
                continue;
            }
            if(d.equals("ALL"))
                s++;
            else if(d.equals("HERE"))
            {
                for(int j = 0; j < n; j++)
                    if(b[j] <= t)
                        c[j]++;
            }
            else
            {
                StringTokenizer st = new StringTokenizer(d);
                while(st.hasMoreTokens())
                {
                    int y = Integer.valueOf(st.nextToken().substring(2));
                    c[y]++;
                }
            }
        }
        for(int i = 0; i < n; i++)
            c[i] += s;
        return c;
    }
}