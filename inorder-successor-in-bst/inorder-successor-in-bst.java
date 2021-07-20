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
    
    private void util(TreeNode root, List<TreeNode> list){
        
        if(root==null)
            return;
        
        util(root.left,list);
        list.add(root);
        util(root.right,list);
        
    }
    
    private void print(List<TreeNode> list){
        
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i).val+" ");
        
        System.out.println();
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        List<TreeNode> list = new ArrayList<>();
        
        util(root,list);
        
        //print(list);
        
        int index = Collections.binarySearch(list,p, (a,b) -> a.val-b.val);
        
        //System.out.println("index-"+index);
        
        if(index<0 || index==list.size()-1)
            return null;
        
        return list.get(index+1);
        
    }
}