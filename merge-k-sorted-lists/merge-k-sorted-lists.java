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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        
        for(ListNode temp : lists){
            if(temp!=null)
                pq.add(temp);
        }
        
        while(!pq.isEmpty()){
            dummy.next = pq.poll();
            dummy = dummy.next;
            if(dummy.next!=null){
                pq.add(dummy.next);
            }
        }
        
        return head.next;
    }
}