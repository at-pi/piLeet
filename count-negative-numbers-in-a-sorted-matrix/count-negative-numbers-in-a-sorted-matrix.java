class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int neg = grid[0].length-1;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]<0){
                count+=grid[0].length;
                continue;
            }
            
            if(grid[i][grid[0].length-1]>0){
                // System.out.println("cont");
                continue;
            }
            
            int l = 0;
            int r = neg;
            while(l<=r){
                int mid = (l+r)/2;
                if(grid[i][mid]<0){
                    r=mid-1;
                }
                else
                    l=mid+1;
            }
            count+=grid[0].length-l;
        }
        return count;
    }
}