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
    
    List<Integer> list = new ArrayList<>();
    
    private void util(TreeNode root){
        if(root==null)
            return;
        util(root.left);
        list.add(root.val);
        util(root.right);
    }
    
    private TreeNode bst(List<Integer> list, int start, int end){
        if(end<start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = bst(list,start,mid-1);
        node.right = bst(list,mid+1,end);
        return node;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        util(root);
        Collections.sort(list);
        //System.out.println(list);
        return bst(list,0,list.size()-1);
    }
}