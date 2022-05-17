/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<Integer> list = new ArrayList<>();
    public int find(TreeNode root, TreeNode target){
        //list.add(root);
        // System.out.println("adding root-"+root.val);
        if(root==target)
            return 1;
        
        if (root.left != null) {
            list.add(-1);
            if (find(root.left,target) == 1) {
                return 1;
            }
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(1);
            if (find(root.right,target) == 1) {
                return 1;
            }
            list.remove(list.size()-1);
        }
        return 0;
    }
    
    public TreeNode give(TreeNode cloned){
        TreeNode curr = cloned;
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(-1)){
                // System.out.println("going left");
                curr = curr.left;
            }
            if(list.get(i).equals(1)){
                // System.out.println("going right");
                curr=curr.right;
            }
        }
        return curr;
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //TreeNode t = original.right.left;
        if (original == null)
            return null;
        find(original,target);
        //for(int i=0;i<list.size();i++)
            //System.out.println(list.get(i));
        //Collections.reverse(list);
        return give(cloned);
    }
}