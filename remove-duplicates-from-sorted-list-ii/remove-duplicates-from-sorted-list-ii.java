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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode curr = null;
        ListNode itr  = head;
        while(itr!=null){
            boolean found=false;
            int dup = itr.val;
            while(itr.next!=null && itr.next.val == dup){
                itr = itr.next;
                found = true;
            }
            if(!found) {
                if(newHead == null) {
                    newHead = new ListNode(dup);
                    curr = newHead;
                } else {
                    curr.next = new ListNode(dup);
                    curr = curr.next;
                }
                    
            }
            itr = itr.next;
        }
        return newHead;
    }
}