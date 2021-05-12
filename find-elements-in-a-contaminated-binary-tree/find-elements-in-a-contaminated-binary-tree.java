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
class FindElements {
    List<Integer> list = new ArrayList<>();
    private void util(TreeNode root,int val){
        if(root==null)
            return;
        root.val = val;
        list.add(root.val);
        util(root.left,2*root.val+1);
        util(root.right,2*root.val+2);
    }
    
    public FindElements(TreeNode root) {
        util(root,0);
    }
    
    public boolean find(int target) {
        return list.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */