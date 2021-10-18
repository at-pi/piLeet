class Solution {
    
    private void visit(char[][] board, int i, int j){
        
        int m = board.length;
        int n = board[0].length;
        
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='.'){
            return;
        }
        
        board[i][j] = '.';
        
        visit(board, i+1, j);
        visit(board, i-1, j);
        visit(board, i, j+1);
        visit(board, i, j-1);
    }
    
    private void print(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public int countBattleships(char[][] board) {
        
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //System.out.println("i - "+i+" j - "+j);
                if(board[i][j] == 'X'){
                    //System.out.println("entered");
                    visit(board, i, j);
                    //print(board);
                    //System.out.println("---------------------");
                    count++;
                }
            }
        }
        return count;
    }
}