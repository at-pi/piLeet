class Solution {
    
    private boolean res;
    private String word;
    
    private boolean recursion(char[][] board, int i, int j, int ind){
        
        //System.out.println(curr);
        //System.out.println(i+" "+j);
        //print(vis);
        
        int m = board.length;
        int n = board[0].length;
        
        if(word.length()==ind)
            return true;
        
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!=word.charAt(ind))
            return false;
        
        board[i][j] = '*';
        
        boolean result = 
            recursion(board, i+1, j, ind+1) ||
            recursion(board, i, j+1, ind+1) ||
            recursion(board, i-1, j, ind+1) || 
            recursion(board, i, j-1, ind+1);
        
        board[i][j] = word.charAt(ind);
        
        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        this.word = word;
        
        int m = board.length;
        int n = board[0].length;
        
        //recursion(board, 0, 0, curr+board[0][0], new int[m][n]);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(recursion(board, i, j, 0))
                    return true;
            }
        }
        
        return false;
    }
}