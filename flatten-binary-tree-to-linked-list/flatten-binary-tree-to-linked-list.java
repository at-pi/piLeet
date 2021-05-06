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
    public void preorder(TreeNode root){
        if(root==null)
            return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        preorder(root);
        for(int i=0;i<list.size();i++){
            list.get(i).left=null;
            if(i!=list.size()-1)
            list.get(i).right = list.get(i+1);
        }
    }
}