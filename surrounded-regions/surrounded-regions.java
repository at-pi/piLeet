class Solution {
    
    int m;
    int n;
    
    public void solve(char[][] board) {
        
        m = board.length;
        n = board[0].length;
        
        char[][] copy = new char[m][n];
        
        
        for(int i=0;i<m;i++)
            recursion(board,copy,i,0);
        
        for(int i=0;i<n;i++)
            recursion(board,copy,0,i);
        
        for(int i=0;i<m;i++)
            recursion(board,copy,i,n-1);
        
        for(int i=0;i<n;i++)
            recursion(board,copy,m-1,i);
        
        util(copy);
        
        garbage(board, copy);
    }
    
    private void recursion(char[][] board, char[][] copy, int i, int j){
        
        if(i<0 || i>=m || j<0 || j>=n || copy[i][j]=='O' || board[i][j]=='X')
            return;
        
        copy[i][j]='O';
        
        recursion(board, copy, i+1, j);
        recursion(board, copy, i, j+1);
        recursion(board, copy, i-1, j);
        recursion(board, copy, i, j-1);
        
    }
    
    private void print(char[][] arr){
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
    private void garbage(char[][] board, char[][] copy){
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=copy[i][j];
            }
        }
        
    }
    
    private void util(char[][] board){
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='O')
                    board[i][j]='X';
            }
        }
        
    }
    
}