class Solution {
    
    private void print(int[][] vis){
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    private void markVisit(int[][] grid, int[][] vis, int i, int j){
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==1 || vis[i][j]==1){
            return;
        }
        
        vis[i][j]=1;
        
        markVisit(grid, vis, i+1, j);
        markVisit(grid, vis, i-1, j);
        markVisit(grid, vis, i, j+1);
        markVisit(grid, vis, i, j-1);
    }
    
    private boolean recursion(int[][] grid, int[][] vis, int i, int j){
        
        //System.out.println("currently at - "+i+" "+j);
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==1 || vis[i][j]==1){
            return true;
        }
        
        vis[i][j] = 1;
        
        if(i+1==m || i-1==-1 || j+1==n || j-1==-1){
            //System.out.println("entered for "+i+" "+j);
            vis[i][j]=0;
            return false;
        }
        
        boolean a = recursion(grid, vis, i+1, j);
        boolean b = recursion(grid, vis, i-1, j);
        boolean c = recursion(grid, vis, i, j+1);
        boolean d = recursion(grid, vis, i, j-1);
        
        boolean bool = (a && b && c && d);
        
        if(!bool)
            return false;
        
        return true;
    }
    
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] vis = new int[m][n];
        int ret = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    vis[i][j]=1;
                }
                else{
                    if(vis[i][j]==0 && recursion(grid, vis, i, j)){
                        //System.out.println("increased for - "+i+" "+j);
                        ret++;
                    }
                }
                //print(vis);
                //System.out.println("------------------------");
            }
        }
        
        return ret;
    }
}