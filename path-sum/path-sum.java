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
    public boolean util(TreeNode root,int target, int curr){
        if(root==null)
            return false;
        curr+=root.val;
        if(target==curr && root.left==null && root.right==null){
            return true;
        }
        if(!util(root.left,target,curr)){
            return util(root.right,target,curr);
        }
        else{
            return true;
        }
    }
    public boolean hasPathSum(TreeNode root, int target) {
        return util(root,target,0);
    }
}