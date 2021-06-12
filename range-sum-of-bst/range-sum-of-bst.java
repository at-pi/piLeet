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
    
    int global = 0;
    
    private int util(TreeNode root, int low, int high, int curr){
        
        if(root==null){
            return 0;
        }
        
        int left = util(root.left,low,high,0);
        int right = util(root.right,low,high,0);
        
        if(root.val>=low && root.val<=high){
            return root.val+left+right;
        }
        else
            return left+right;
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {        
        return util(root,low,high,0);
    }
}