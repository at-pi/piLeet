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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode newHead = new ListNode(-1);
        ListNode newCurr = newHead;
        
        int currSum = 0;
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.val == 0){
                curr = curr.next;
                while(curr.val != 0){
                    //System.out.println(curr.val+" ");
                    currSum += curr.val;
                    curr = curr.next;
                }
            }
            ListNode temp = new ListNode(currSum);
            newCurr.next = temp;
            newCurr = newCurr.next;
            currSum = 0;
            //curr = curr.next;
        }
        
        return newHead.next;
    }
}