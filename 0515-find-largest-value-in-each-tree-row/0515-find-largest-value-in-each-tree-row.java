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
    public List<Integer> largestValues(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        if(root == null)
            return l;
        q.add(root);
        while(!q.isEmpty())
        {
            int mx = Integer.MIN_VALUE, s = q.size();
            while(s-- > 0)
            {
                TreeNode p = q.poll();
                if(p.val > mx)
                    mx = p.val;
                if(p.left != null)
                    q.add(p.left);
                if(p.right != null)
                    q.add(p.right);
            }
            l.add(mx);
        }
        return l;
    }
}