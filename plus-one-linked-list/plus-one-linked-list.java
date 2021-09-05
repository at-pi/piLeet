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
    
    private ListNode rev(ListNode head){
        
        ListNode prev = null;
        ListNode next = head;
        ListNode curr = head;
        
        while(next!=null){
            //System.out.println(curr.val);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    private void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println();
    }
    
    public ListNode plusOne(ListNode head) {
        
        ListNode newHead = rev(head);
        int carry = 1;
        
        ListNode curr = newHead;
        ListNode prev = null;
        while(carry!=0){
            if(curr == null){
                ListNode end = new ListNode(1);
                prev.next = end;
                break;
            }
            if(curr.val+1 == 10){
                curr.val = 0;
            }
            else{
                curr.val = curr.val+1;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        
        return rev(newHead);
    }
}