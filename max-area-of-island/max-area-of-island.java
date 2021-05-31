class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int temp=countD(grid,i,j,0);
                    max = Math.max(temp,max);
                }
            }
        }
        return max;
    }
    public int countD(int[][] grid,int i,int j,int curr){
        if(i<0||i>=grid.length || j>=grid[0].length || j<0 ||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
            
        int l = countD(grid,i+1,j,0);
        int r = countD(grid,i-1,j,0);
        int u = countD(grid,i,j+1,0);
        int d = countD(grid,i,j-1,0);
        
        return 1+l+r+u+d;
    }
}