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
    List<Integer> list = new ArrayList<>();
    int i = 0;
    private void fill(TreeNode root){
        if(root==null)
            return;
        fill(root.left);
        list.add(root.val);
        fill(root.right);
    }
    
    public BSTIterator(TreeNode root) {
        fill(root);
    }
    
    public int next() {
        return list.get(i++);
    }
    
    public boolean hasNext() {
        return i<=list.size()-1?true:false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */