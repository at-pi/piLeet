class Solution {
    public String longestCommonPrefix(String[] strs) {
        String smallest = strs[0];
        
        for(int i=0; i<strs.length; i++){
            if(strs[i].length() < smallest.length()){
                smallest = strs[i];
            }
        }
        
        String lcp = "";
        
        for(int i=0; i<smallest.length(); i++){
            
            char currentChar = strs[0].charAt(i);
            
            for(int j=0; j<strs.length; j++){
                if(strs[j].charAt(i) != currentChar){
                    return lcp;
                }
            }
            
            lcp += String.valueOf(currentChar);
        }
        
        return lcp;
    }
}