/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    
    private Node findParent(Node x){
        if(x.parent == null)
            return x;
        else
            return findParent(x.parent);
    }
    
    private Node lca(Node root, Node p, Node q){
        if(root == null)
            return null;
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        
        if(left == null && right != null)
            return right;
        
        if(left !=null && right == null)
            return left;
        
        if(left !=null && right !=null)
            return root;
        
        return null;
    }
    
    public Node lowestCommonAncestor(Node p, Node q) {
        Node parent = findParent(q);
        return lca(parent, p, q);
    }
}