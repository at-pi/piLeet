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
    int mlevel = 0;
    int max = Integer.MIN_VALUE;
    private void levelOrder(TreeNode root){
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);
        //TreeNode curr = q.poll();
        int level = 1;
        int currsum = 0;
        while(q.size()!=0){
            //System.out.println("size- "+q.size());
            int s = q.size();
            for(int i=0;i<s;i++){
                //System.out.println("for ");
                TreeNode curr = q.poll();
                currsum+=curr.val;
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                
                //System.out.print(curr.val+" ");
                
            }
            if(currsum>max){
                    //System.out.println("changed");
                    max  = currsum;
                    mlevel = level;
                }
            //System.out.println(currsum);
            currsum=0;
            
            level++;
            
        }
    }
    
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        levelOrder(root);
        return mlevel;
    }
}