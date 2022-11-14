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
    
    private boolean check(TreeNode root, int curr, int target){
        if(root == null){
            return false;
        }
        curr = curr+root.val;
        
        if(curr == target && root.left == null && root.right == null){
            return true;
        } else {
            return check(root.left, curr, target) || check(root.right, curr, target);
        }
        
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        return check(root, 0, targetSum);
    }
}