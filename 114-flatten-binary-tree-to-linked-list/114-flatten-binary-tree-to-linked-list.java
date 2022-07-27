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
    List<TreeNode> list;
    
    private void preorder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
    
    public void flatten(TreeNode root) {
        
        list = new ArrayList<>();
        preorder(root);
        
        TreeNode temp = root;
        for(int i=1; i<list.size(); i++){
            temp.left = null;
            temp.right = list.get(i);
            temp = list.get(i);
        }
        
    }
}