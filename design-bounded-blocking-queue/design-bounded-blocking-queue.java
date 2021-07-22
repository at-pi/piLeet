class BoundedBlockingQueue {
    
    Semaphore enq;
    Semaphore deq;
    Queue<Integer> q;
    int capacity;
    
    public BoundedBlockingQueue(int capacity) {
        this.q = new LinkedList<>();
        this.enq = new Semaphore(capacity,true);
        this.deq = new Semaphore(0,true);
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        enq.acquire();
        q.add(element);
        deq.release();
    }
    
    public int dequeue() throws InterruptedException {
        deq.acquire();
        int temp = q.poll();
        enq.release();
        return temp;
    }
    
    public int size() {
        return q.size();
    }
}
