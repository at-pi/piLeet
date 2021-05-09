class Solution {
    int count = 0;
    private void util(int[][] grid,int[][] vis,int i,int j,int curr,int obst){
        //System.out.println(i+" "+j+" "+curr);
        int[][] copyArray =new int[vis.length][];
        for (int o = 0; o < copyArray.length; ++o) {
         copyArray[o] = new int[vis[o].length];
         for (int p = 0; p < copyArray[o].length; ++p) {
            copyArray[o][p] = vis[o][p];
         }
      }
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }
        if(grid[i][j]==2){
            if(curr==((m*n)-1-obst)){
                count++;
            }
            else
               return;
        }
        if(grid[i][j]!=-1){
            if(copyArray[i][j]==0){
                copyArray[i][j]=1;
                curr++;
                if(i+1<m)
                    util(grid,copyArray,i+1,j,curr,obst);
                if(j+1<n)
                    util(grid,copyArray,i,j+1,curr,obst);
                if(i-1>=0)
                    util(grid,copyArray,i-1,j,curr,obst);
                if(j-1>=0)
                    util(grid,copyArray,i,j-1,curr,obst);
            }
            else{
                return;
            }
        }
        else{
            return;
        }
    }
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int starti = -1;
        int endi = -1;
        //int endf = -1;
        //int startf = -1;
        int obst = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    starti = i;
                    endi = j;
                }
                // if(grid[i][j]==2){
                //     startf = i;
                //     endf = j;
                // }
                if(grid[i][j]==-1){
                    obst++;
                }
            }
        }
        //System.out.println((m*n)-1-obst);
        int[][] vis = new int[m][n];
        util(grid,vis,starti,endi,0,obst);
        return count;
    }
}