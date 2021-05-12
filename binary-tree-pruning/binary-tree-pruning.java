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
    private boolean find1(TreeNode root){
        if(root==null)
            return false;
        if(root.val==1)
            return true;
        return find1(root.left)|| find1(root.right);
        
    }
    private TreeNode util(TreeNode root){
        if(root==null)
            return null;
        TreeNode temp = new TreeNode(root.val);
        if(find1(root.left))
            temp.left = util(root.left);
        if(find1(root.right))
            temp.right = util(root.right);
        if(temp.left==null && temp.right==null && temp.val==0)
            return null;
        return temp;
    }
    
    
    public TreeNode pruneTree(TreeNode root) {
        
        return util(root);
        
    }
}