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
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return make(root1, root2);
    }
    
    private TreeNode make(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null && root2 != null)
            return root2;
        if(root1 != null && root2 == null)
            return root1;
        TreeNode n = new TreeNode(root1.val+root2.val);
        n.left = make(root1.left, root2.left);
        n.right = make(root1.right, root2.right);
        return n;
    }
}