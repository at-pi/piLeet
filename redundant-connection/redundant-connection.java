class Solution {
    
    int[] arr;
    int[] ret;
    private int find(int i){
        if(arr[i]==-1)
            return i;
        return find(arr[i]);
    }
    
    private void union(int i, int j){
        
        int firstP = find(i);
        int secondP = find(j);
        
        if(firstP == secondP ){
            ret[0] = i;
            ret[1] = j;
            return;
        }
        
        arr[firstP] = secondP;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length+1;
        this.arr = new int[n];
        this.ret = new int[2];
        
        for(int i=0;i<n;i++){
            arr[i] = -1;
        }
        
        for(int[] temp : edges){
            union(temp[0],temp[1]);
        }
        
        return ret;
    }
}