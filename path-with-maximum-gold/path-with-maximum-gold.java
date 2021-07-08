class Solution {
    
    int max = -1;
    
    private void util(int[][] grid, int[][] vis, int curr, int i, int j){
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j]==1 || grid[i][j]==0)
            return;
        
        vis[i][j]=1;
        
        curr+= grid[i][j];
        
        if(curr>max)
            max = curr;
        
        util(grid,vis,curr,i+1,j);
        util(grid,vis,curr,i,j+1);
        util(grid,vis,curr,i-1,j);
        util(grid,vis,curr,i,j-1);
        
        vis[i][j]=0;
            
    }
    
    public int getMaximumGold(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        int[][] vis = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                util(grid, vis, 0, i, j);
            }
        }
        
        return max;
    }
}