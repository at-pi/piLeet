class Solution {
    
    private void flipCol(int[][] grid, int col){
        for(int i=0; i<grid.length; i++){
            grid[i][col] = grid[i][col] == 1 ?  0 : 1;
        }
    }
    
    public boolean removeOnes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<n ; i++){
            if(grid[0][i] == 1){
                flipCol(grid, i);
            }
        }
        
        for(int i=1; i<m; i++){
            int cons = grid[i][0];
            for(int j=0; j<n; j++){
                if(grid[i][j] != cons)
                    return false;
            }
        }
        
        return true;
    }
}