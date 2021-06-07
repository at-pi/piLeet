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
    
    int count =0;
    
    private int height(TreeNode root){
        if(root==null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    
    private void util(TreeNode root){
        if(root==null)
            return;
        util(root.left);
        count++;
        util(root.right);
    }
    
    public int countNodes(TreeNode root) {
        util(root);
        return count;
    }
}