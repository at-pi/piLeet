class LRUCache {
    
    private void print(Node start, Node end){
        System.out.println("size-"+size);
        if(start==null){
            System.out.println("empty queue");
            return;
        }
        else if(start==end){
            System.out.println("size of one");
            System.out.print(start.val+"-");
            System.out.println("EOL");
            return;
        }
        else{
            Node temp = start;
            while(temp!=null){
                System.out.print(temp.val+"-");
                temp=temp.next;
            }
            System.out.println("EOL");
        }
    }
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        
    }
    
    Node start;
    Node end;
    int capacity;
    int size;
    Map<Integer,Node> map;
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        this.start = null;
        this.end = null;
        this.size = 0;
        this.map = new HashMap<>();
        //print(start,end);
    }
    
    public int get(int key) {
        
        Node getNode = map.get(key);
        
        if(getNode==null){
            //print(start,end);
            return -1;
        }
        
        // if(size==1)
        //     return getNode.val;
        
        if(getNode.next == null){
            //print(start,end);
            return getNode.val;
        }
        
        if(getNode.prev == null){
            //System.out.println("entered for-"+getNode.val);
            getNode.next.prev = null;
            start = getNode.next;
            end.next = getNode;
            getNode.prev = end;
            getNode.next = null;
            end = getNode;
            //print(start,end);
            return getNode.val;
        }
        
        else{
            getNode.next.prev = getNode.prev;
            getNode.prev.next = getNode.next;
            end.next = getNode;
            getNode.prev = end;
            getNode.next = null;
            end = getNode;
            //print(start,end);
            return getNode.val;
        }
        
    }
    
    public void put(int key, int value) {
        
        Node temp = new Node(key,value);
        //System.out.println("putting node - "+temp.key);
        
        if(size == 0){
            start = temp;
            end = temp;
            map.put(key,temp);
            size++;
            //print(start,end);
            return;
        }
        
        Node found = map.get(key);
        if(found!=null){
            get(key);
            found.val = value;
            map.put(key,found);
            //print(start,end);
        }
        
        else if(size==1 && capacity==1){
            int removedKey = start.key;
            start=temp;
            end=temp;
            //print(start,end);
            map.remove(removedKey);
            map.put(key,temp);
            return;
        }
        
        else if(size>0 && size<capacity) {
            //System.out.println("between capacity");
            end.next = temp;
            temp.prev = end;
            end = temp;
            map.put(key,temp);
            size++;
            //print(start,end);
            return;
        }
        
        else if(size==capacity){
            int removedKey = start.key;
            //System.out.println("removed key - "+removedKey);
            map.remove(removedKey);
            start.next.prev = null;
            start = start.next;
            end.next = temp;
            temp.prev=end;
            end = temp;
            map.put(key,temp);
            //print(start,end);
            return;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */