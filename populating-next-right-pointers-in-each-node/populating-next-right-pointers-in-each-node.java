/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    List<List<Node>> list = new ArrayList<>();
    
    private void bfsUtil(Node root){
        
        Node curr = root;
        Queue<Node> q = new LinkedList<>();
        q.add(curr);
        List<Node> lTemp = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            Node temp = q.element();
            for(int i=0;i<size;i++){
                
                temp = q.poll();
            
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            
                //System.out.print(temp.val+" ");
                lTemp.add(temp);
            }
            list.add(new ArrayList<>(lTemp));
            lTemp.clear();
            //System.out.println();
        }
        
    }
    
    public Node connect(Node root) {
        if(root==null)
            return null;
        bfsUtil(root);
        //System.out.println(list);
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                //System.out.print(list.get(i).get(j).val+" ");
                if(j==list.get(i).size()-1){
                    //System.out.print("setting "+list.get(i).get(j).val+"'s right to null");
                    list.get(i).get(j).next=null;
                }
                else{
                    //System.out.print("setting "+list.get(i).get(j).val+"'s right to "+list.get(i).get(j+1).val);
                    list.get(i).get(j).next=list.get(i).get(j+1);
                }
            }
            //System.out.println();
        }
        return root;
    }
}