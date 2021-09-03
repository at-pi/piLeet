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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode ret = curr;
        ListNode next = head;
        int count = 0;
        //System.out.println("curr - "+curr.val+" next - "+next.val+" count - "+count);
        while(next!=null){
            while(count!=m && next!=null){
                //System.out.println("curr - "+curr.val+" next - "+next.val+" count - "+count);
                curr = curr.next;
                next = next.next;
                
                count++;
            }
            count = 0;
            while(count!=n && next!=null){
                //System.out.println("curr - "+curr.val+" next - "+next.val+" count - "+count);
                next=next.next;
                
                count++;
            }
            curr.next = next;
            count=0;
        }
        
        return ret.next;
    }
}