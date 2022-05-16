class Solution {
    private static final int[][] directions = 
        new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (grid[0][0] != 0 || grid[m-1][n-1] != 0)
            return -1;
        
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if(row == m-1 && col == n-1){
                return distance;
            }
            for(int[] neighbour : getNeighbours(row, col, grid)){
                int nR = neighbour[0];
                int nC = neighbour[1];
                queue.add(new int[]{nR, nC});
                grid[nR][nC] = distance + 1;
            }
        }
        return -1;
    }
    
    private List<int[]> getNeighbours(int row, int col, int[][] grid){
        List<int[]> neighbours = new ArrayList<>();
        for(int i=0; i<directions.length; i++){
            int nR = row + directions[i][0];
            int nC = col + directions[i][1];
            if (nR < 0 || nC < 0 || nR >= grid.length || nC >= grid[0].length || grid[nR][nC] != 0) {
                continue;    
            }
            neighbours.add(new int[]{nR, nC});
        }
        return neighbours;
    }
}