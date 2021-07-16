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
    
    private TreeNode util(TreeNode root, char c){
        if(root==null)
            return null;
        if((root.left==null && root.right==null) || c=='r')
            return root;
        TreeNode temp = util(root.left,'l');
        TreeNode right = util(root.right,'r');
        root.left=null;
        root.right=null;
        temp.left = right;
        temp.right = root;
        if(c=='l')
            return root;
        else
            return temp;
    }
    
    private TreeNode find(TreeNode root){
        TreeNode temp = root;
        TreeNode ret = null;
        while(temp!=null){
            ret = temp;
            temp = temp.left;
        }
        return ret;
    }
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode temp = find(root);
        util(root,'l');
        return temp;
    }
}