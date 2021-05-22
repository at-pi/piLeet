/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        Stack<ListNode> s = new Stack<>();
        ListNode x = new ListNode(0);
        ListNode t1 = head;
        ListNode t2 = x;
        
        while(t1!=null){
            s.push(t1);
            t1 = t1.next;
            //System.out.println("pushed - "+t1.val);
            if(s.size()==k){
                while(!s.isEmpty()){
                    t2.next = s.pop();
                    //System.out.println("popped - "+t2.next.val);
                    t2 = t2.next;
                }
            }
            
        }
        
        Stack<ListNode> s2 = new Stack<>();
        while(!s.isEmpty()){
            s2.push(s.pop());
        }
        
        while(!s2.isEmpty()){
            t2.next = s2.pop();
            t2=t2.next;
        }
        ListNode temp = x;
        t2.next=null;
        return x.next;
    }
}