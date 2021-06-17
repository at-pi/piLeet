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
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>(); 
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);
        temp=head;
        int i=0;
        while(temp!=null){
            temp.val = (list.get(i));
            temp = temp.next;
            i++;
        }
        return head;
    }
}