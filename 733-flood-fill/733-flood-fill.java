class Solution {
    
    private void fill(int row, int col, int[][] image, int orgColor, int[][] vis, int newColor){
        //System.out.println("row - "+row+" col - "+col);
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || vis[row][col] ==1 || image[row][col] != orgColor){
            return;
        }
        vis[row][col] = 1;
        fill(row+1, col, image, orgColor, vis, newColor);
        fill(row-1, col, image, orgColor, vis, newColor);
        fill(row, col+1, image, orgColor, vis, newColor);
        fill(row, col-1, image, orgColor, vis, newColor);
        
        image[row][col] = newColor;
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int[][] vis = new int[image.length][image[0].length];
        fill(sr, sc, image,image[sr][sc] , vis, newColor);
        
        return image;
    }
}