class Solution {
    
    private int util(int[][] dp, int[][] matrix, int i, int j){
        //System.out.println(i+" "+j+" "+matrix[i][j]);
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left = -1;
        int right = -1;
        int up = -1;
        int down = -1;
        
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j])
            left = util(dp,matrix,i-1,j);
        
        if(i+1<matrix.length && matrix[i+1][j]>matrix[i][j])
            right = util(dp,matrix,i+1,j);
        
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j])
            up = util(dp,matrix,i,j-1);
        
        if(j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j])
            down = util(dp,matrix,i,j+1);
        
        //System.out.println("left-"+left +" right-"+right+" up-"+up+" down-"+down);
        
        int temp = Math.max(Math.max(left,right),Math.max(up,down));
        if(temp == -1)
            dp[i][j] = 1;
        else
            dp[i][j] = 1+temp;
        
        return dp[i][j];
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ret = Integer.MIN_VALUE;
        
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==-1){
                    dp[i][j] = util(dp,matrix,i,j);
                }
                if(dp[i][j]>ret)
                    ret = dp[i][j];
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        return ret;
    }
}