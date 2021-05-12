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
    int curr = 0;
    private void util(TreeNode root){
        if(root==null)
            return;
        util(root.right);
        root.val+=curr;
        curr = root.val;
        //System.out.print(curr+" ");
        util(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        util(root);
        return root;
    }
}