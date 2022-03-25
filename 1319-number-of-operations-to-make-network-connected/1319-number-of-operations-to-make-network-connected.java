class Solution {
    
    int[] arr;
    
    private int parent(int v){
        if(arr[v] == -1){
            return v;
        }
        
        return parent(arr[v]);
    }
    
    public int makeConnected(int n, int[][] connections) {
        
        this.arr = new int[n];
        Arrays.fill(arr, -1);
        
        int extra = 0;
        
        for(int[] itr: connections){
            //System.out.println("itr - " + itr[0] + " " + itr[1]);
            int a = parent(itr[0]);
            int b = parent(itr[1]);
            //System.out.println("parents "+ a + " " + b);
            if(a == b ){
                ++extra;
                continue;
            }
            else{
                arr[b] = a;
            }
        }
        int ans = 0;
        
        for(int i=0; i<n ; i++){
            if(arr[i] == -1)
                ++ans;
        }
        
        //System.out.println(" parts - " + ans + " extra edges - " + extra);
        
        return ans-1 > extra ? -1 : ans-1; 
    }
}