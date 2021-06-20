class Solution {
    
    private int LCA(String text1, int n, String text2, int m){
        if(n<0 || m<0)
            return 0;
        if(text1.charAt(n)==text2.charAt(m))
            return 1+LCA(text1,n-1,text2,m-1);
        else{
            return Math.max(LCA(text1,n,text2,m-1),LCA(text1,n-1,text2,m));
        }
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        //return LCA(text1,n-1,text2,m-1);
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        
        return dp[n][m];
    }
}