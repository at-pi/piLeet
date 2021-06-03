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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null)
            return null;
        
        ListNode temp1 = head;
        if(temp1.next==null)
            return temp1;
        
        ListNode temp2 = temp1.next;
        
        temp1.next = swapPairs(temp2.next);
        temp2.next = temp1;
        
        return temp2;
        
    }
}