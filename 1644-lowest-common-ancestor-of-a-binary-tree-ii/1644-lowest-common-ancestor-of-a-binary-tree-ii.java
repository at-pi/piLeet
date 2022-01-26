/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    boolean pFound;
    boolean qFound;
    
    private void inorder(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == null)
            return;
        
        if(root == p)
            this.pFound = true;
        if(root == q)
            this.qFound = true;
        
        inorder(root.left, p, q);
        inorder(root.right, p, q);
    }    
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        
        if(root == p){
            this.pFound = true;
            return root;
        }
        
        if(root == q){
            this.qFound = true;
            return root;
        }
        
        if(left == null && right != null)
            return right;
        
        if(left != null && right == null)
            return left;
        
        if(left != null && right != null)
            return root;
        
        return null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        this.pFound = false;
        this.qFound = false;
        
        //inorder(root, p, q);
        
        TreeNode res = lca(root, p, q);
        
        if(pFound && qFound)
            return res;
        else
            return null;
    }
}