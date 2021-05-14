class Solution {
    
    private int util(Stack<Integer> stack, String s){
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)!=')'){
                stack.push(Integer.MAX_VALUE);
            }
            else if(s.charAt(i)==')'){
                int j = 0;
                while(stack.peek()!=Integer.MAX_VALUE){
                    j+=stack.pop();
                }
                stack.pop();
                if(j==0){
                    stack.push(1);
                }
                else{
                    stack.push(2*j);
                }
            }
            i++;
        }
        int ret=0;
        while(!stack.isEmpty()){
            ret+=stack.pop();
        }
        return ret;
    }
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        return util(stack,s);
    }
}