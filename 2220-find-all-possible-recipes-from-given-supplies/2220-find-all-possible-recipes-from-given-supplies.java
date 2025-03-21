class Solution
{
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies)
    {
        Set<String> st=new HashSet<>(),l=new HashSet<>();
        for(String x: supplies)
            st.add(x);
        while(true)
        {
            int f=0;
            outer:
            for(int i=0;i<recipes.length;i++)
            {
                for(String x: ingredients.get(i))
                    if(!st.contains(x))
                        continue outer;
                l.add(recipes[i]);
                if(!st.contains(recipes[i]))
                {
                    st.add(recipes[i]);
                    f=1;
                }
            }
            if(f==0)
                break;
        }
        return new ArrayList<>(l);
    }
}