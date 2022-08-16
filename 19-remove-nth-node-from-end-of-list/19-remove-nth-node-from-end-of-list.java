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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode itr = head;
        int i=0;
        
        while(i<n){
            itr = itr.next;
            i++;
        }
        
        ListNode e = head;
        
        if(itr == null){
            return head.next;
        }
        
        while(itr.next != null){
            e = e.next;
            itr = itr.next;
        }
        
        e.next = e.next.next;
        
        return head;
    }
}