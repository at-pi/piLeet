class FrontMiddleBackQueue {
    int size;
    DLL front,rear,mid;
    class DLL{
        int val;
        DLL next;
        DLL prev;
        DLL(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private void print(){
        DLL temp = front;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public FrontMiddleBackQueue() {
        this.size=0;
        front = null;
        rear = null;
        mid = null;
    }
    
    public void pushFront(int val) {
        DLL temp = new DLL(val);
        if(size==0){
            front = temp;
            mid = temp;
            rear = temp;
            size++;
            //print();
            return;
        }
        temp.next = front;
        front.prev = temp;
        front = temp;
        size++;
        if(size%2==0){
            mid = mid.prev;
        }
        //System.out.println("pf");
        //print();
    }
    
    public void pushMiddle(int val) {
        DLL temp = new DLL(val);
        if(size==0){
            front = temp;
            mid = temp;
            rear = temp;
            size++;
            //print();
            return;
        }
        if(size==1){
            temp.next = front;
            front.prev = temp;
            front = temp;
            mid = temp;
            size++;
            //print();
            return;
        }
        if(size%2==0){
            //System.out.println("even size");
            DLL temp2 = mid.next;
            mid.next = temp;
            temp.prev = mid;
            temp.next = temp2;
            temp2.prev = temp;
            mid = mid.next;
            //print();
            size++;
            return;
        }
        if(size%2==1){
            //System.out.println("odd size");
            DLL temp2 = mid.prev;
            temp2.next = temp;
            temp.prev = temp2;
            temp.next = mid;
            mid.prev = temp;
            mid = mid.prev;
            size++;
            //print();
            return;
        }
        
    }
    
    public void pushBack(int val) {
        DLL temp = new DLL(val);
        if(size==0){
            front = temp;
            mid = temp;
            rear = temp;
            size++;
            return;
        }
        size++;
        temp.prev = rear;
        rear.next = temp;
        rear=temp;
        if(size%2==1){
            mid = mid.next;
        }
        //System.out.println("pb");
        //print();
    }
    
    public int popFront() {
        if(size==0)
            return -1;
        int temp = front.val;
        size--;
        if(size==0){
            front = null;
            rear = null;
            mid = null;
            return temp;
        }
        front = front.next;
        if(size%2==1)
            mid=mid.next;
        front.prev = null;
        //print();
        return temp;
    }
    
    public int popMiddle() {
        if(size==0)
            return -1;
        int temp = mid.val;
        if(size==1){
            front = null;
            rear = null;
            mid = null;
            size--;
            return temp;
        }
        if(size==2){
            front = rear;
            mid = rear;
            size--;
            //print();
            return temp;
        }
        if( size % 2 == 0 ){
            DLL temp1 = mid.next;
            temp1.prev = mid.prev;
            mid.prev.next = temp1;
            mid = temp1;
            size--;
            //print();
            return temp;
        }
        else{
            DLL temp1 = mid.prev;
            temp1.next = mid.next;
            mid.next.prev = temp1;
            mid=temp1;
            size--;
            //print();
            return temp;
        }
    }
    
    public int popBack() {
        if(size==0)
            return -1;
        int temp = rear.val;
        size--;
        if(size==0){
            front=null;
            rear=null;
            mid=null;
            return temp;
        }
        rear = rear.prev;
        if(size%2==0){
            mid = mid.prev;
        }
        rear.next = null;
        //print();
        return temp;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */