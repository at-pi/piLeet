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
    private boolean util(TreeNode left, TreeNode right){
        if(left==null && right == null)
            return true;
        else if(left!=null && right==null)
            return false;
        else if(left==null && right!=null)
            return false;
        else{
            if(left.val==right.val){
                return util(left.left,right.right) && util(left.right,right.left);
            }
            else{
                return false;
            }
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return util(root,root);
    }
}