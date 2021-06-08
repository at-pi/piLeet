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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)
            return null;
        
        //System.out.println(root.val);
        
        if(root.val<low){
            //System.out.println("entered for-"+root.val);
            root = trimBST(root.right,low,high);
            //System.out.println("changed value?-"+root.val);
        }
        else if(root.val>high){
            //System.out.println("entered high-"+root.val);
            root = trimBST(root.left,low,high);
        }
        else{
            //System.out.println("entered else-"+root.val);
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }
        return root;
    }
}