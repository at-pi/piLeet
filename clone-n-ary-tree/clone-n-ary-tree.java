/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    private Node clone(Node root, Node cloneRoot){
        
        if(root==null)
            return null;
        
        if(cloneRoot == null)
            cloneRoot = new Node(root.val);
        
        for(int i=0;i<root.children.size();i++){
            cloneRoot.children.add(clone(root.children.get(i),null));
        }
        
        return cloneRoot;
    }
    
    public Node cloneTree(Node root) {
        
        return clone(root,null);
        
    }
}