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
    String small = "";
    
    private void util(TreeNode root,String s){
        if(root==null)
            return;
        s+=String.valueOf((char)(root.val+97));
        //System.out.println(s);
        
        if(root.left==null && root.right==null){
            StringBuilder strb = new StringBuilder(s);
            strb.reverse();
            String x = String.valueOf(strb);
            //System.out.println("original-"+x+" "+small);
            if(small.equals(""))
                small = x;
            else{
                small = small.compareTo(x)>0?x:small;
            }
            //System.out.println("Changed-"+x+" "+small);
            return;
        }
        util(root.left,s);
        util(root.right,s);
    }
        
    public String smallestFromLeaf(TreeNode root) {
        util(root,"");
        return small;
    }
}