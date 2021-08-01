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
    int postIndex = 0;
    private TreeNode treeBuild(int[] inorder,int[] postorder,int start,int end){
        if(start>end)
            return null;
        
        TreeNode temp = new TreeNode(postorder[postIndex--]);
        
        if(start==end)
            return temp;
        
        int index = search(inorder,temp.val);
        
        temp.right = treeBuild(inorder,postorder,index+1,end);
        temp.left = treeBuild(inorder,postorder,start,index-1);
        
        
        return temp;
    }
    
    private int search(int[] inorder,int val){
        for(int i=0;i<inorder.length;i++){
            if(val == inorder[i])
                return i;
        }
        return -1;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        return treeBuild(inorder,postorder,0,postorder.length-1);
    }
}