/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Node itr = head;
        
        while(itr!=null){
            Node temp = new Node(itr.val);
            temp.next = itr.next;
            itr.next = temp;
            itr = temp.next;
        }
        
        itr = head;
        
        while(itr!=null && itr.next!=null){
            if(itr.random != null)
                itr.next.random = itr.random.next;
            itr = itr.next.next;
        }
        
        Node newHead = head.next;
        Node itrO = head;
        itr = head.next;
        
        while(itrO!=null && itr!=null && itr.next!=null){
//             if(itr.next == null){
//                 break;
//             }
            
//             itr.next = itr.next.next;
//             itr = itr.next;
            itrO.next = itr.next;
            itr.next = itr.next.next;
            itrO = itrO.next;
            itr = itr.next;
        }
        itrO.next = null;
        
        return newHead;
    }
}