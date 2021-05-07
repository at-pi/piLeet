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
    private int height(TreeNode root){
        if(root==null)
            return 0;
        int lh = height(root.left)+1;
        int rh = height(root.right)+1;
        return Math.max(lh,rh);
    }
    
    private boolean util(TreeNode root){
        if(root==null)
            return true;
        int lh  = height(root.left)+1;
        int rh = height(root.right)+1;
        return Math.abs(lh-rh)<=1?util(root.left)&&util(root.right):false;
    }
    
    public boolean isBalanced(TreeNode root) {
        //System.out.println(height(root));
        return util(root);
    }
}