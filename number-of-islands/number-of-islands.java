class Solution {
    public int numIslands(char[][] grid) {
        int numCount =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    numCount+=countD(grid,i,j);
                }
            }
        }
        return numCount;
    }
    public int countD(char[][] grid,int i,int j){
        if(i<0||i>=grid.length || j>=grid[0].length || j<0 ||grid[i][j]=='0'){
            return 0;
        }
            grid[i][j]='0';
            countD(grid,i+1,j);
            countD(grid,i-1,j);
            countD(grid,i,j+1);
            countD(grid,i,j-1);
        return 1;
    }
}