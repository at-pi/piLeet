class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0)
            return true;
        Stack<Integer> s = new Stack<>();
        s.push(pushed[0]);
        int i=1;
        int j=0;
        while(i<pushed.length && j<popped.length){
            if(!s.isEmpty() && s.peek()==popped[j]){
                s.pop();
                j++;
            }
            else{
                s.push(pushed[i]);
                i++;
            }
        }
        if(j==popped.length && i<pushed.length)
            return false;
        while(!s.isEmpty() && s.peek()==popped[j] ){
            s.pop();
            j++;
        }
        if(!s.isEmpty())
            return false;
        if(j<popped.length)
            return false;
        return true;
    }
}