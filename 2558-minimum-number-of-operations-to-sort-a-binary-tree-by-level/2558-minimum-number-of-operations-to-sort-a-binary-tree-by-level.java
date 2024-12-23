class Solution
{
    public int minimumOperations(TreeNode root)
    {
        if(root == null)
            return 0;
        List<TreeNode> q = new ArrayList<>();
        int c = 0;
        q.add(root);
        while(!q.isEmpty())
        {
            List<TreeNode> q1 = new ArrayList<>();
            for(int i = 0; i < q.size(); i++)
            {
                TreeNode p = q.get(i);
                if(p.left != null)
                    q1.add(p.left);
                if(p.right != null)
                    q1.add(p.right);
            }
            q = q1;
            c += count(q);
        }
        return c;
    }

    int count(List<TreeNode> l)
    {
        int n = l.size(), a[] = new int[n], p[][] = new int[n][2], c = 0;
        for(int i = 0; i < n; i++)
            a[i] = l.get(i).val;

        for(int i = 0; i < n; i++)
        {
            p[i][0] = a[i];
            p[i][1] = i;
        }

        Arrays.sort(p, (x, y) -> x[0] - y[0]);
        boolean v[] = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(v[i] || i == p[i][1])
                continue;
            int s = 0, x = i;
            while(!v[x])
            {
                v[x] = true;
                x = p[x][1];
                s++;
            }
            if(s > 1)
                c += s - 1;
        }
        return c;
    }
}