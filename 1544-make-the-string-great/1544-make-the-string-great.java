class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            else{
                if(Math.abs(stack.peek() - s.charAt(i)) == 32){
                    stack.pop();
                    continue;
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}