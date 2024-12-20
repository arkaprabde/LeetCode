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
    public TreeNode reverseOddLevels(TreeNode root)
    {
        if(root == null)
            return root;
        List<TreeNode> l = new ArrayList<>();
        l.add(root);
        int lvl = 0;
        while(true)
        {
            if(lvl % 2 != 0)
                for(int i = 0; i < l.size() / 2; i++)
                {
                    int t = l.get(i).val;
                    l.get(i).val = l.get(l.size() - i - 1).val;
                    l.get(l.size() - i - 1).val = t;
                }
            if(l.get(0).left == null)
                break;
            List<TreeNode> l2 = new ArrayList<>();
            for(int i = 0; i < l.size(); i++)
            {
                l2.add(l.get(i).left);
                l2.add(l.get(i).right);
            }
            l = l2;
            lvl++;
        }
        return root;
    }
}