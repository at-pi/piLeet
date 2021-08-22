class Solution {
    
    int total = 0;
    
    private void dfs(int[][] isConnected, int[] vis, int i){
        
        if(vis[i]==1)
            return;
        
        //System.out.println("node - " + i);
        
        int n = isConnected.length;
        
        vis[i] = 1;
        
        
        for(int k=0;k<n;k++){
            if(isConnected[i][k]==1 && vis[k]==0)
                dfs(isConnected, vis, k);
        }
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int numOfIslands = isConnected.length;
        
        int[] vis = new int[numOfIslands];
        
        for(int i=0;i<numOfIslands;i++){
            
            if(vis[i]!=1){
                total++;
                //System.out.println("new call");
                dfs(isConnected, vis, i);
            }
                
        }
        
        return total;
    }
    
    public int countComponents(int n, int[][] edges) {
        
        int[][] isConnected = new int[n][n];
        
        for(int i=0;i<n;i++){
            isConnected[i][i]=1;
        }
        
        for(int[] arr : edges){
            isConnected[arr[0]][arr[1]]=1;
            isConnected[arr[1]][arr[0]]=1;
        }
        
        return findCircleNum(isConnected);
    }
}