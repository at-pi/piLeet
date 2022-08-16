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
    public boolean isPalindrome(ListNode head) {
        
        ListNode a = head;
        ListNode b = head;
        Stack<Integer> stack = new Stack<>();
        
        while(b!=null && b.next!=null){
            stack.push(a.val);
            a = a.next;
            b = b.next.next;
        }
        
        ListNode breakPoint = a;
        
        if(b!=null && b.next == null){
            a = a.next;
        }
        
        while(a!=null){
            int x = stack.pop();
            //System.out.println(a.val +" "+x);
            if(a.val != x){
                return false;
            }
            a = a.next;
        }
        
        return true;
    }
}