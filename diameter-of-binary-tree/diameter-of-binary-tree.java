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
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    
    private int dia(TreeNode root){
        if(root==null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(1+lh+rh,Math.max(dia(root.left),dia(root.right)));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return dia(root)-1;
    }
}