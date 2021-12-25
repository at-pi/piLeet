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
    
    private TreeNode lca(TreeNode root, int p, int q){
        
        if(root == null)
            return null;
        
        if(root.val == p || root.val == q)
            return root;
        
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        
        if(left == null)
            return right;
        
        if(right == null)
            return left;
        
        return root;
    }
    
    private int findDist(TreeNode lca, int x, int curr){
        
        if(lca == null)
            return -1;
        
        if(x == lca.val)
            return curr;

        int left = findDist(lca.left, x, curr+1);
        
        return left == -1 ? findDist(lca.right, x, curr+1) : left;
        
    }
    
    public int findDistance(TreeNode root, int p, int q) {
        
        TreeNode lca = lca(root, p, q);
        
        int left = findDist(lca, p, 0);
        int right = findDist(lca, q, 0);
        
        return left + right;
    }
}