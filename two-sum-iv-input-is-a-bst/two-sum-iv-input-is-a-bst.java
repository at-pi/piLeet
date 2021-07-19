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
    
    private void util(TreeNode root, List<Integer> list){
        
        if(root==null)
            return;
        
        if(root.left!=null)
            util(root.left,list);
        list.add(root.val);
        if(root.right!=null)
            util(root.right,list);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        
        util(root,list);
        
        Set<Integer> set = new HashSet<>();
        
        for(int i : list){
            if(set.contains(k-i))
                return true;
            set.add(i);
        }
        return false;
    }
}