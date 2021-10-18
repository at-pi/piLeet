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
    
    TreeNode culprit;
    
    public List<List<TreeNode>> levelOrder(TreeNode root) {
        
        List<List<TreeNode>> list = new LinkedList<>();
        
        if(root==null)
            return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            List<TreeNode> levelList = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                
                TreeNode temp = q.poll();
                //System.out.print(temp.val+" ");
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                
                levelList.add(temp);
            }
            //System.out.println();
            list.add(levelList);
            
        }
        return list;
    }
    
    private void check(List<List<TreeNode>> list){
        for(int i=0;i<list.size();i++){
            List<TreeNode> levelList = list.get(i);
            for(int j=0;j<levelList.size();j++){
                TreeNode suspect = levelList.get(j);
                if(levelList.contains(suspect.right)){
                    culprit = suspect;
                    return;
                }
            }
        }
    }
    
    private void findAndRemove(TreeNode root, TreeNode culprit){
        if(root==null)
            return;
        if(root.left == culprit){
            root.left = null;
            return;
        }
        if(root.right == culprit){
            root.right = null;
            return;
        }
        findAndRemove(root.left, culprit);
        findAndRemove(root.right, culprit);
    }
    
    public TreeNode correctBinaryTree(TreeNode root) {
        List<List<TreeNode>> list = levelOrder(root);
        check(list);
        //System.out.println(culprit.val);
        findAndRemove(root, culprit);
        return root;
    }
}