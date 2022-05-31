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
        
        ListNode temp = head;
        int i = 1;
        
        while(i < n){
            temp = temp.next;
            i++;
        }
        
        ListNode prev = null;
        ListNode ans = head;
        
        while(temp.next!=null){
            temp = temp.next;
            prev = ans;
            ans = ans.next;
        }
        //System.out.println("prev - "+prev.val+" ans - "+ans.val);
        if(ans.next == null){
            if(prev == null)
                return null;
            prev.next = null;
        }
        else{
            if(prev == null){
                return ans.next;
            }
            prev.next = ans.next;
        }
        return head;
    }
}