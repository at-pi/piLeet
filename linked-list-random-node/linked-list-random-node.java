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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    Map<Integer,ListNode> map;
    
    public Solution(ListNode head) {
        map = new HashMap<>();  
        int i = 1;
        while(head!=null){
            map.put(i++,head);
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int Min = 1;
        int Max = map.size();
        int k = Min + (int)(Math.random() * ((Max - Min) + 1));
        return map.get(k).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */