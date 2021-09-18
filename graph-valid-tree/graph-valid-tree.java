class Solution {
    int[] arr;
    
    private int find(int node){
        if(arr[node]==-1)
            return node;
        return find(arr[node]);
    }
    
    private void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    private boolean union(int node1, int node2){
        
        int node1Parent = find(node1);
        int node2Parent = find(node2);
        
        //System.out.println("parent1 "+node1Parent+" parent2 "+node2Parent);
        
        if(node1Parent==node2Parent){
            return false;
        }
        
        arr[node1Parent] = node2Parent;
        
        return true;
    }
    
    public boolean validTree(int n, int[][] edges) {
        
        if(n==1)
            return true;
        
        if(n>1 && edges.length==0)
            return false;
        
        arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = -1;
        }
        //print(arr);
        for(int i=0;i<edges.length;i++){
            if(!union(edges[i][0],edges[i][1]))
                return false;
            //System.out.println("after "+i+"th operation");
            //print(arr);
        }
        
        int parent = find(0);
        
        //System.out.println("final");
        //print(arr);
        
        for(int i=1;i<n;i++){
            if(find(i)!=parent)
                return false;
        }
        
        return true;
    }
}