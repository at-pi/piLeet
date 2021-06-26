class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] div = new int[k];
        for(int i=0;i<arr.length;i++){
            int n = arr[i]%k;
            if(n<0)
                n+=k;
            div[n]++;
        }
        if(div[0]%2!=0)
            return false;
        for(int i=1;i<=k/2;i++){
            if(div[i]!=div[k-i]){
                return false;
            }
        }
        //System.out.println(-3%3);
        return true;
    }
}