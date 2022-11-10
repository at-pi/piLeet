class Solution {
    public String removeDuplicates(String str) {
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            if(s.isEmpty()){
                s.push(str.charAt(i));
            } else{
                if(s.peek() == str.charAt(i)){
                    s.pop();
                } else {
                    s.push(str.charAt(i));
                }
            }
        }
        
        String ans = "";
        while(!s.isEmpty()){
            ans = s.pop() + ans;
        }
        return ans;
    }
}