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
    
    private void print(List<TreeNode> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).val);
        }
        System.out.println();
    }
    
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        int flag = 0;
        
        q.add(temp);
        
        while(!q.isEmpty()){
            
            List<TreeNode> list = new ArrayList<>();
            int size  = q.size();
            
            for(int i=0 ; i<size ; i++){
                
                temp = q.poll();
                list.add(temp);
                
                if( temp == u){
                    flag = 1;
                }
                
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                
            }
            //print(list);
            int j = 0;
            if(flag==1){
                for(int i=0; i<list.size() ; i++){
                    if( list.get(i) == u){
                        j = i;
                        break;
                    }
                }
                if(j+1<list.size()){
                    return list.get(j+1);
                }
                else{
                    return null;
                }
            }
            
            
        }
        
        return null;
    }
}