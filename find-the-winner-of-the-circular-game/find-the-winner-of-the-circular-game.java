class Solution {
    
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = next;
        }
    }
    
    public int findTheWinner(int n, int k) {
        
        if(k==1)
            return n;
        
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        for(int i=1;i<=n;i++){
            Node temp = new Node(i);
            curr.next = temp;
            curr = temp;
        }
        
        curr.next = dummy.next;
        Node head = dummy.next;
        int size = n;
        curr = head;
        //System.out.println("head-"+curr.val+"size-"+size);
        int j = 0;
        while(size>1){
            System.out.println("iteration - "+j++);
            Node prev = null;
            for(int i=0;i<k-1;i++){
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            curr = curr.next;
            System.out.println("prev-"+prev.val+" curr-"+curr.val);
            size--;
        }
        
        return curr.val;
        
    }
}