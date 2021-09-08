class Solution {
    
    int M;
    Map<Integer,Integer> map;
    Random r;
    
    public Solution(int n, int[] blacklist) {
        
        map =  new HashMap<>();
        
        for(int x : blacklist){
            map.put(x,-1);
        }
        
        M = n-map.size();
        
        for(int x : blacklist){
            if(x<M){
                while(map.containsKey(n-1))
                    n--;
                map.put(x,n-1);
                n--;
            }
        }
        
        r= new Random();
    }
    
    public int pick() {
        int x = r.nextInt(M);
        if(map.containsKey(x))
            return map.get(x);
        return x;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */