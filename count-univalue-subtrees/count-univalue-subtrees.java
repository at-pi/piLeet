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
    
    private int util(TreeNode root){
        if(root==null)
            return -1001;
        if(root.left==null && root.right==null){
            global++;
            return root.val;
        }
        if(root.left==null && root.right!=null){
            int temp = util(root.right);
            if(temp==root.val){
                global++;
                return temp;
            }
            else
                return -1001;
        }
        if(root.left!=null && root.right==null){
            int temp2 = util(root.left);
            if(temp2==root.val){
                global++;
                return temp2;
            }
            else
                return -1001;
        }
        int left = util(root.left);
        int right = util(root.right);
        
        if(left!=right || left!=root.val || right!=root.val){
            return -1001;
        }
        
        if(left==right && left==root.val){
            global++;
            return left;
        }
        
        return -1001;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        util(root);
        return global;
    }
}