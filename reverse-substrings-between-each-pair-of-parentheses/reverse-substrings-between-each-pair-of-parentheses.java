class Solution {
    
    private String util(Stack<Character> stack, String s){
        String str = "";
        int i = 0;
        while(i<=s.length()-1){
            // if(stack.isEmpty()){
            //     stack.push(s.charAt(i));
            // }
            if(s.charAt(i)==')'){
                while(stack.peek()!='('){
                    str+=stack.pop();
                }
                //System.out.println("inter-"+str);
                stack.pop();
                int j = 0;
                while(j<str.length()){
                    stack.push(str.charAt(j));
                    j++;
                }
                str="";
            }
            if(s.charAt(i)!=')')
                stack.push(s.charAt(i));
            i++;
            //System.out.println(stack);
        }
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        //System.out.println(str);
        StringBuilder strb = new StringBuilder(str);
        return String.valueOf(strb.reverse());
    }
    
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        return util(stack,s);
    }
}