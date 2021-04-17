class Solution {
    class UtilObj{
        Character c;
        int n;
        public UtilObj(Character c, int n){
            this.c=c;
            this.n=n;
        }
    }
    public String util(String s,Stack<UtilObj> stack,int k){
        //int temp = 0;
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                UtilObj uo = new UtilObj(s.charAt(i),1);
                stack.push(uo);
            }
            else{
                if(Character.compare(stack.peek().c,s.charAt(i))==0){
                    //System.out.println("matched");
                    UtilObj uo = new UtilObj(s.charAt(i),stack.peek().n+1);
                    stack.push(uo);
                }
                else{
                    UtilObj uo = new UtilObj(s.charAt(i),1);
                    stack.push(uo);
                }
            }
            if(stack.peek().n>=k){
                for(int j=0;j<k;j++){
                    stack.pop();
                }
            }
        }
        StringBuilder strb = new StringBuilder();
        while(!stack.isEmpty()){
            strb.append(stack.pop().c);
        }
        return String.valueOf(strb.reverse());
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<UtilObj> stack = new Stack<>();
        return util(s,stack,k);
    }
}