class Solution {
    
    private int check(int[][] grid, int i, int j, char dir){
        int m = grid.length;
        int n = grid[0].length;
        //System.out.println("i - "+i+" j - "+j+" dir - "+dir);
        
        if(i>=m){
            return j;
        }
        
        if(j<0 || j>=n || i<0){
            return -1;
        }
        
        if(dir == 'D'){
            if(grid[i][j] == 1){
                return check(grid, i, j+1, 'R');
            }
            else{
                return check(grid, i, j-1, 'L');
            }
        }
        else if(dir == 'R'){
            if(grid[i][j] == 1){
                return check(grid, i+1, j, 'D');
            }
            else{
                return check(grid, i-1, j, 'U');
            }
        }
        else if(dir == 'L'){
            if(grid[i][j] == 1){
                return check(grid, i-1, j, 'U');
            }
            else{
                return check(grid, i+1, j, 'D');
            }
        }
        else if(dir == 'U'){
            return -1;
        }
        return -1;
    }
    
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        
        //check(grid, 0, 0, 'D');
        
        for(int i=0; i<n; i++){
            ans[i] = check(grid, 0, i, 'D');
        }
        
        return ans;
    }
}