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
        ListNode nth = head;
        int i = 1;
        while(i<n){
            nth = nth.next;
            i++;
        }
        
        ListNode itr = head;
        ListNode prev = null;
        while(nth.next != null){
            nth = nth.next;
            prev = itr;
            itr=itr.next;
        }
        
        if(itr.next != null){
            itr.val = itr.next.val;
            itr.next = itr.next.next;
        }
        else{
            if(prev == null)
                return null;
            prev.next = null;
        }
        return head;
    }
}