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
    //List<Integer> list = new ArrayList<>();
    int sum=0;
    private void util(TreeNode root,String s){
        if(root==null)
            return;
        s+=String.valueOf(root.val);
        //System.out.println(s);
        
        if(root.left==null && root.right==null){
            sum+=Integer.valueOf(s);
            //System.out.println(s);
            return;
        }
        util(root.left,s);
        util(root.right,s);
    }
    
    public int sumNumbers(TreeNode root) {
        util(root,"");
        return sum;
    }
}