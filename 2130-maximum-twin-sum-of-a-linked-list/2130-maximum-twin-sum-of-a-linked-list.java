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
    public int pairSum(ListNode head) {
        
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }
        
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = list.size()-1;
        
        while(i<j){
            max = Math.max(max, list.get(i++)+list.get(j--));
        }
        
        return max;
    }
}