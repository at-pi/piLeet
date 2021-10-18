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
    
    private void recursion(TreeNode root, List<Integer> util){
        
        if(root == null)
            return;
        //System.out.print("root - "+root.val);
        if(root.left!=null){
            TreeNode temp = root.left;
            //System.out.print(" left - "+temp.val);
            if(temp.left == null && temp.right == null){
                util.add(temp.val);
                root.left = null;
            }
            else{
                recursion(temp, util);
            }
        }
        
        if(root.right!=null){
            TreeNode temp = root.right;
            //System.out.println(" right - "+temp.val);
            if(temp.left == null && temp.right == null){
                util.add(temp.val);
                root.right = null;
            }
            else{
                recursion(temp, util);
            }
        }
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        while(root.left != null || root.right !=null){
            List<Integer> ret = new ArrayList<>();
            recursion(root, ret);
            list.add(ret);
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(root.val);
        list.add(ret);
        return list;
    }
}