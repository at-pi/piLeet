class BrowserHistory {
    
    class Node {
        String url;
        Node next;
        Node prev;
        public Node(String url){
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }
    
    Node curr = null;
    
    public BrowserHistory(String homepage) {
        //System.out.println("creating homepage - "+homepage);
        this.curr = new Node(homepage);
    }
    
    public void visit(String url) {
        //System.out.println("creating new - "+url);
        Node temp = new Node(url);
        this.curr.next = temp;
        temp.prev = this.curr;
        this.curr = temp;
        //System.out.println("current now after creating - "+this.curr.url);
    }
    
    public String back(int steps) {
        //System.out.println("current b - "+this.curr.url);
        if(steps == 0 || this.curr.prev == null){
            //System.out.println("steps0/prevNull - returning "+this.curr.url);
            return this.curr.url;
        }
        
        this.curr = this.curr.prev;
        return back(steps-1);
    }
    
    public String forward(int steps) {
        //System.out.println("current f - "+this.curr.url);
        if(steps == 0 || this.curr.next == null){
            //System.out.println("steps0/nextNull - returning "+this.curr.url);
            return this.curr.url;
        }
        
        this.curr = this.curr.next;
        return forward(steps-1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */