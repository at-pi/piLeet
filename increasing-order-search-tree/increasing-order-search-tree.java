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
    TreeNode head = new TreeNode(0);
    TreeNode prev = head;
    private void put(int temp){
        
        TreeNode t = new TreeNode(temp);
        //System.out.print(t.val+" ");
        prev.right = t;
        prev=t;;
    }
    
    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        
        put(root.val);
        inorder(root.right);
    } 
    
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head.right;
    }
}