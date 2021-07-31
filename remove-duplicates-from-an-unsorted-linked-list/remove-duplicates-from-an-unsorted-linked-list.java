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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        
        ListNode temp = head;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        while(temp!=null){
            map.put(temp.val, map.getOrDefault(temp.val,0)+1);
            temp = temp.next;
        }
        //System.out.println(map);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;;
        temp = dummy;
        
        while(temp!=null && temp.next!=null){
            //System.out.println("temp - "+temp.val);
            if(map.get(temp.next.val)>1){
                //System.out.println("inside if");
                ListNode curr = temp.next;
                //System.out.println("curr val - "+curr.val);
                int i = 0;
                while(curr!=null && map.get(curr.val)>1){
                    //System.out.println("iteration - "+i++);
                    //System.out.println("curr val - "+curr.val);
                    curr=curr.next;
                }
                temp.next = curr;
                temp = curr;
            }
            else{
                //System.out.println("inside else");
                temp = temp.next;
            }
        }
        
        return dummy.next;
    }
}