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
    
    double temp = Double.MAX_VALUE;
    int min = -1;
    
    private void util(TreeNode root, double target){
        
        if(root==null)
            return;
        
        //System.out.println(root.val+" "+Math.abs(root.val - target));
        
        if(Math.abs(root.val - target)<temp){
            min = root.val;
            temp = Math.abs(root.val - target);
        }
        
        util(root.left,target);
        util(root.right,target);
    }
    
    public int closestValue(TreeNode root, double target) {
        util(root,target);
        return min;
    }
}