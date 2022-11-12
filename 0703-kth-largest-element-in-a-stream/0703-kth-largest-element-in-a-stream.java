class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0; i<nums.length; i++){
            if(pq.size() == k){
                if(pq.peek() > nums[i]){
                    continue;
                }
                else {
                    pq.poll();
                }
            }
            
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        
        if(pq.size() < k){
            pq.add(val);
            if(pq.size() == k)
                return pq.peek();
        }
        
        if(pq.peek() > val){
            return pq.peek();
        }
        
        if(pq.size() == k){
            pq.poll();
        }
        pq.add(val);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */