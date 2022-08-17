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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode last = even;
        
        while(true){
            if(odd == null || even == null || even.next == null){
                odd.next = last;
                break;
            }
            odd.next = even.next;
            odd = even.next;
            
            if(odd.next == null){
                even.next = null;
                odd.next = last;
                break;
            }
            
            even.next = odd.next;
            even = odd.next;
            
        }
        return head;
    }
}