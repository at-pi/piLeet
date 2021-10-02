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
    
    List<Integer> list;
    
    private void  recursion(TreeNode root){
        
        if(root==null)
            return;
        
        if(root.left==null && root.right!=null){
            list.add(root.right.val);
        }
        if(root.right==null && root.left!=null){
            list.add(root.left.val);
        }
        
        recursion(root.left);
        recursion(root.right);
    }
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        
        this.list = new ArrayList<>();
        
        recursion(root);
        
        return list;
    }
}