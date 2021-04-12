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
    public ListNode reverse(ListNode head){
        ListNode next=null;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        //System.out.println(head1.val+" "+head1.next.val+" "+head1.next.next.val);
        ListNode head3 = new ListNode();
        ListNode curr = head3;
        int carry = 0;
        while(head1!=null && head2!=null){
            int x = head1.val+head2.val+carry;
            int rem = x%10;
            carry = x/10;
            curr.val = rem;
            ListNode temp = new ListNode();
            curr.next = temp;
            curr= curr.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head2==null){
            while(head1!=null){
                int x = head1.val + carry;
                int rem = x%10;
                carry = x/10;
                curr.val = rem;
                ListNode temp = new ListNode();
                curr.next = temp;
                head1 = head1.next;
                curr = curr.next;
            }
        }
        else if(head1==null){
            while(head2!=null){
                int x = head2.val + carry;
                int rem = x%10;
                carry = x/10;
                curr.val = rem;
                ListNode temp = new ListNode();
                curr.next = temp;
                head2 = head2.next;
                curr = curr.next;
            }
        }
        if(carry!=0){
            //System.out.println("hi");
            curr.val = carry;
        }
        else{
            //System.out.println("hi");
            curr = null;
        }
        ListNode head4 = reverse(head3);
        if(head4.val==0)
            return head4.next;
        else
            return head4;
    }
}