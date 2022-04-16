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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head == null || head.next == null)
            return null;
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            //System.out.println(slow.val+" "+fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        
        return head;
    }
}