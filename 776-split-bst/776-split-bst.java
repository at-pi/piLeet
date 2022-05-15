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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root == null){
            return new TreeNode[]{null, null};
        }
        
        TreeNode[] splitted = new TreeNode[2];
        if(root.val <= target){
            splitted = splitBST(root.right, target);
            root.right = splitted[0];
            splitted[0] = root;
        }
        else{
            splitted = splitBST(root.left, target);
            root.left = splitted[1];
            splitted[1] = root;
        }
        return splitted;
    }
}