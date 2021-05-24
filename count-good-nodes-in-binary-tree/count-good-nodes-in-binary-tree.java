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
    
    private void util(TreeNode root, int max){
        if(root==null)
            return;
        if(root.val>=max){
            //System.out.println("root- "+root.val+" max-"+max);
            global++;
            max = root.val;
        }
        util(root.left,max);
        util(root.right,max);
    }
    
    public int goodNodes(TreeNode root) {
        util(root,Integer.MIN_VALUE);
        return global;
    }
}