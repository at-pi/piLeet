class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 1){
            return 0;
        }
        
        int ans = 0;
        int n = prices.length;
        
        int leftMax = prices[n-1];
        
        for(int i=n-2; i>=0; i--){
            if(prices[i+1] > leftMax){
                leftMax = prices[i+1];
            }
            if(ans < (leftMax - prices[i])){
                ans = leftMax - prices[i];
            }
        }
        return ans;
    }
}