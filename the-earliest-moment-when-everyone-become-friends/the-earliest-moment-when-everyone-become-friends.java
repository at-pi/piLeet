class Solution {
    int total = 0;
    
    private void print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
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
    
    public int countComponents(int n, int[] arr, int[][] isConnected) {
        
        isConnected[arr[0]][arr[1]]=1;
        isConnected[arr[1]][arr[0]]=1;
        
        //System.out.println("IsConnected - ");
        //print(isConnected);
        
        int k = findCircleNum(isConnected);
        //System.out.println("total Components - "+k);
        return k;
    }
    
    public int earliestAcq(int[][] logs, int n) {
        
        Arrays.sort(logs, (a,b) -> a[0]-b[0]);
        
        int[][] isConnected = new int[n][n];
        
        for(int i=0;i<n;i++){
            isConnected[i][i]=1;
        }
        
        for(int i=0;i<logs.length;i++){
            total = 0;
            int[] arr = new int[2];
            arr[0] = logs[i][1];
            arr[1] = logs[i][2];
            
            if(countComponents(n,arr,isConnected)==1)
                return logs[i][0];
        }
        
        return -1;
    }
}