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
    
    List<TreeNode> roots;
    
    public boolean findRootUntilTarget(TreeNode root, List<TreeNode> roots, TreeNode target){
        if(root == null)
            return false;
        
        roots.add(root);
        
        if(root == target)
            return true;
        
        if(findRootUntilTarget(root.left, roots, target) || findRootUntilTarget(root.right, roots, target)){
            return true;
        }
        
        roots.remove(roots.size()-1);
        return false;
    }
    
    private void findFromTarget(TreeNode root, int k, int curr, List<Integer> ans){
        if(root == null || curr>k){
            return;
        }
        
        if(curr == k){
            ans.add(root.val);
            return;
        }
        
        findFromTarget(root.left, k, curr+1, ans);
        findFromTarget(root.right, k, curr+1, ans);
        
    }
    
    private void findFromRoot(TreeNode root, int k, int curr, List<Integer> ans){
        //System.out.println(root.val);
        if(root == null || curr > k || roots.contains(root)){
            return;
        }   
        
        //System.out.println(root.val);
        
        if(curr == k){
            ans.add(root.val);
            return;
        }
        
        findFromRoot(root.left, k, curr+1, ans);
        findFromRoot(root.right, k, curr+1, ans);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        this.roots = new ArrayList<>();
    
        findRootUntilTarget(root, roots, target);
        
        List<Integer> ans = new ArrayList<>();
        // for(int i=0;i<roots.size();i++){
        //     System.out.print(roots.get(i).val+" ");
        // }
        // System.out.println();
        
        //findFromTarget(target, k, 0, ans);
        int s = roots.size();
        
        for(int i=0;i<s;i++){
            TreeNode dem = roots.get(0);
            roots.remove(0);
            findFromRoot(dem, k, s - i - 1, ans);
        }
        
        return ans; 
    }
}