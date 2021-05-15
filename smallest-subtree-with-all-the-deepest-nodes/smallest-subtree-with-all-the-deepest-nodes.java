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
    int max  = -1;
    TreeNode res = null;
    
    private int postorder(TreeNode root,int depth){
        if(root==null)
            return depth;
        
        int left = postorder(root.left,depth+1);
        int right = postorder(root.right,depth+1);
        
        if(left==right){
            max = Math.max(max,left);
            
            if(max==right){
                res = root;
            }
            
        }
        return Math.max(left,right);
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        postorder(root,0);
        return res;
    }
}