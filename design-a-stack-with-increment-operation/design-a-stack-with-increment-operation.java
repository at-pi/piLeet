class CustomStack {
    int max = -1;
    Stack<Integer> stackOrg;
    public CustomStack(int maxSize) {
        max = maxSize;
        stackOrg = new Stack<>();
    }
    
    public void push(int x) {
        if(stackOrg.size()==max)
            return;
        stackOrg.push(x);
    }
    
    public int pop() {
        if(stackOrg.size()==0)
            return -1;
        else
            return stackOrg.pop();
    }
    
    public void increment(int k, int val) {
        Stack<Integer> stackTemp = new Stack<>();
        int t1 = stackOrg.size()-k;
        while(t1>0){
            stackTemp.push(stackOrg.pop());
            t1--;
        }
        while(k>0 && !stackOrg.isEmpty()){
            stackTemp.push(stackOrg.pop()+val);
        }
        while(!stackTemp.isEmpty()){
            stackOrg.push(stackTemp.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */