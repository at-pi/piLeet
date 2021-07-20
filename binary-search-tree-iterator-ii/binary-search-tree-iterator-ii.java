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
class BSTIterator {
    
    int index = -1;
    List<Integer> list;
    
    private void util(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        
        util(root.left,list);
        list.add(root.val);
        util(root.right,list);
        
    }
    
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        util(root,list);
    }
    
    public boolean hasNext() {
        if(index+1<list.size())
            return true;
        return false;
    }
    
    public int next() {
        index++;
        return list.get(index);
    }
    
    public boolean hasPrev() {
        if(index-1>=0)
            return true;
        return false;
    }
    
    public int prev() {
        index--;
        return list.get(index);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */