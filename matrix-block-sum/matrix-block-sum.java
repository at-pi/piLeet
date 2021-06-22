class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] - dp[i][j] + mat[i][j];
                //System.out.print(dp[i+1][j+1]+" ");
            }
            //System.out.println();
        }
        
        int[][] ans = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1 = Math.max(0,i-k);
                int c1 = Math.max(0,j-k);
                int r2 = Math.min(m,i+k+1);
                int c2 = Math.min(n,j+k+1);
                
                ans[i][j] = dp[r2][c2] - dp[r2][c1] - dp[r1][c2] + dp[r1][c1];
            }
        }
        return ans;
    }
}