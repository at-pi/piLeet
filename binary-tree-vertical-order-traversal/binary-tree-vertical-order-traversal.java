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
    
    private class Combo{
        
        int val;
        int height;
        int horizontalDist;
        
        Combo(int val, int height, int horizontalDist){
            this.val = val;
            this.height = height;
            this.horizontalDist = horizontalDist;
        }
    }
    
    private void util(TreeNode root, int height, int horizontalDist , Map<Integer,List<Combo>> map){
        
        if(root==null)
            return;
        
        Combo combo = new Combo(root.val,height,horizontalDist);
        
        if(map.containsKey(horizontalDist)){
            List<Combo> list = map.get(horizontalDist);
            list.add(combo);
        }
        else{
            List<Combo> list = new ArrayList<>();
            list.add(combo);
            map.put(horizontalDist,list);
        }
        
        util(root.left,height+1,horizontalDist-1,map);
        util(root.right,height+1,horizontalDist+1,map);
    }
    
    private List<Integer> print(List<Combo> list){
        List<Integer> ret = new ArrayList<>();
        for(Combo c : list){
            ret.add(c.val);
        }
        return ret;
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,List<Combo>> map = new TreeMap<>();
        
        util(root,0,0,map);
        
        //System.out.println(map);
        for(List<Combo> e : map.values()){
            //print(e);
            Collections.sort(e, (a,b) -> a.height!=b.height ? a.height-b.height : 0);
            //print(e);
            list.add(print(e));
        }
        return list;
    }
}