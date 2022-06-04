class Solution {
    
    private boolean compare(int[] s1A, int[] s2A){
        for(int i=0; i<256; i++){
            if(s1A[i] != s2A[i])
                return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length())
            return false;
        
        int[] s1A = new int[256];
        int[] s2A = new int[256];
        
        for(int i=0; i<s1.length(); i++){
            s1A[s1.charAt(i)]++;
        }
        for(int i=0; (i+s1.length()) <= s2.length(); i++){
            for(int j=i; j<i+s1.length(); j++){
                s2A[s2.charAt(j)]++;
            }
            if(compare(s1A, s2A))
                return true;
            s2A = new int[256];
        }
        
        return false;
    }
}