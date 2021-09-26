class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length()+1;
        
        boolean[] arr = new boolean[n];
        arr[0]=true;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] && wordDict.contains(s.substring(j,i))){
                    arr[i]=true;
                    break;
                }
            }
        }
        
        return arr[s.length()];
    }
}