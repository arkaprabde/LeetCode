class Solution {
    public List<String> stringMatching(String[] w) {
        int n = w.length;
        List<String> l = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if(i != j && w[j].contains(w[i]))
                {
                    l.add(w[i]);
                    break;
                }
        }
        return l;
    }
}