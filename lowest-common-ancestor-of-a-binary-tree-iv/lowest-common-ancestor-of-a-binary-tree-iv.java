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
    
    private TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2){
        
        
        if(root == null)
            return null;
        
        if(root == node1 || root == node2)
            return root;
        
        TreeNode left = lca(root.left, node1, node2);
        TreeNode right = lca(root.right, node1, node2);
        
        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        
        if(nodes.length == 0)
            return null;
        
        if(nodes.length == 1)
            return nodes[0];
        
        TreeNode lcaNode = lca(root, nodes[0], nodes[1]);
        
        for(int i=2;i<nodes.length;i++){
            lcaNode = lca(root, lcaNode, nodes[i]);
        }
        
        return lcaNode;
    }
}