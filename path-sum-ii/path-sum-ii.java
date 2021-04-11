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
    List<List<Integer>> list = new ArrayList<>();
    public boolean func(TreeNode root, int curr, int target, List<Integer> l){
        if(root!=null)
            System.out.println("root-"+root.val+" curr-"+curr+" target-"+target+" list-"+l);
        if(root==null)
            return false;
        if(curr==target){
            if(root.left==null && root.right==null){
                l.add(root.val);
                List<Integer> l1 = new ArrayList<>(l);
                System.out.println(l1);
                list.add(l1);
            }
        }
        
        List<Integer> l2 = new ArrayList<>(l);
        List<Integer> l3 = new ArrayList<>(l);
        
        
        if(root.left!=null){
            l2.add(root.val);
            if(!func(root.left,curr+root.left.val,target,l2))
                l2.remove(l2.size()-1);
        }
        if(root.right!=null){
            l3.add(root.val);
            if(!func(root.right,curr+root.right.val,target,l3))
                l3.remove(l3.size()-1);
        }
        return true;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return list;
        List<Integer> l = new ArrayList<>();
        func(root,root.val,targetSum,l);
        return list;
    }
}