class Solution {
    public int minAddToMakeValid(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i<=str.length()-1){
            if(s.isEmpty()){
                s.push(str.charAt(i));
            }
            else if(str.charAt(i)=='('){
                s.push('(');
            }
            else if(str.charAt(i)==')'){
                if(s.peek()=='('){
                    s.pop();
                }
                else{
                    s.push(')');
                }
            }
            i++;
        }
        System.out.println(s);
        return s.size();
    }
}