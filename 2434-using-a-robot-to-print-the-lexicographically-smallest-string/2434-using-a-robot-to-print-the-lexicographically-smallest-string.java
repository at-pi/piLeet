class Solution {
    
    private boolean hasSmaller(int[] fre, char c){
        for(int i=0; i<26; i++){
            if(fre[i]>0 && i < (c-'a'))
                return true;
        }
        return false;
    }
    
    public String robotWithString(String s) {
        if(s == null || s.length() == 0) return "";
        
        int n = s.length();
        int[] fre = new int[26];
        
        for(int i=0; i<n; i++){
            fre[s.charAt(i)-'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            stack.push(s.charAt(i));
            fre[s.charAt(i)-'a']--;
            
            while(!stack.isEmpty()){
                if(hasSmaller(fre, stack.peek())) break;
                sb.append(stack.pop());
            }
            
        }
        
        return sb.toString();
    }
}