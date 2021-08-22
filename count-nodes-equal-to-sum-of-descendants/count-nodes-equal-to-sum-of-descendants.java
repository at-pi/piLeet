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
    
    int count = 0;
    
    private int sum(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left = sum(root.left);
        int right = sum(root.right);
        
        //System.out.println("node - "+root.val+ " root.id - "+ root +" left - "+root.left+" right - "+root.right +" sum - "+(left+right));
        
        if(root.val==(left+right))
            ++count;
        
        return left+right+root.val;
    }
    
    public int equalToDescendants(TreeNode root) {
        sum(root);
        return count;
    }
}