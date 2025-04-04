/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    Map<TreeNode,TreeNode> mp=new HashMap<>();
    List<List<TreeNode>> l=new ArrayList<>();
    public TreeNode lcaDeepestLeaves(TreeNode root)
    {
        build(root,null,1);
        List<TreeNode> a=l.get(l.size()-1);
        while(a.size()>1)
        {
            Set<TreeNode> b=new HashSet<>();
            for(TreeNode x:a)
                b.add(mp.get(x));
            a=new ArrayList<>(b);
        }
        return a.get(0);
    }

    void build(TreeNode x, TreeNode y, int d)
    {
        if(x==null)
            return;
        mp.put(x,y);
        if(d>l.size())
            l.add(new ArrayList<>());
        l.get(d-1).add(x);
        build(x.left,x,d+1);
        build(x.right,x,d+1);
    }
}