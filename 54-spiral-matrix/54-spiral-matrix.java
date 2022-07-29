class Solution {
    
    List<Integer> list;
    int[][] dir;
    
    private boolean visit(int[][] matrix, int[][] visited, int i, int j, int d){
        //System.out.println("i - "+i+" j - "+j);
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] == 1){
            return false;
        }
        list.add(matrix[i][j]);
        //System.out.println(matrix[i][j]);
        visited[i][j] = 1;
        
        i = i+dir[d][0];
        j = j+dir[d][1];
        
        if(!visit(matrix, visited, i, j, d)){
            i = i - dir[d][0];
            j = j - dir[d][1];
            d = d+1;
            d = d%4;
            i = i+dir[d][0];
            j = j+dir[d][1];
            visit(matrix, visited, i, j, d);
        }
        return true;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        this.list = new ArrayList<>();
        int[][] dir1 = {{0,1} , {1,0}, {0,-1}, {-1,0}};
        
        this.dir = dir1;
        
        int[][] visited = new int[matrix.length][matrix[0].length];
        
        visit(matrix, visited, 0, 0, 0);
        
        return list;
    }
}