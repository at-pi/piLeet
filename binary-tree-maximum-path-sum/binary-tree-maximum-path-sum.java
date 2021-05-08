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
    int max = Integer.MIN_VALUE;
    private int util(TreeNode root){
        if(root==null)
            return 0;
        int ls = util(root.left);
        int rs = util(root.right);
        
        int maxs = Math.max(Math.max(ls,rs)+root.val,root.val);
        
        int maxw = Math.max(maxs,ls+rs+root.val);
        max = Math.max(maxw,max);
        
        //System.out.println(max+" "+maxw+" "+maxs);
        return maxs;
    }
    
    public int maxPathSum(TreeNode root) {
        util(root);
        return max;
    }
}