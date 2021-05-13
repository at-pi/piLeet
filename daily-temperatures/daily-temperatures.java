class Solution {
    
    private class Pair{
        int temp;
        int index;
        Pair(int temp, int index){
            this.temp = temp;
            this.index = index;
        }
    }
    
    private int[] util(int[] temp, Stack<Pair> s){
        int[] ret = new int[temp.length];
        int i = 0;
        while(i<=temp.length-1){
            if(s.isEmpty()){
                s.push(new Pair(temp[i],i));
            }
            else{
                while(!s.isEmpty() && s.peek().temp<temp[i]){
                    Pair p = s.pop();
                    ret[p.index] = i-p.index;
                }
                s.push(new Pair(temp[i],i));
            }
            i++;
        }
        while(!s.isEmpty()){
            Pair p = s.pop();
            ret[p.index] = 0;
        }
        return ret;
    }
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s = new Stack<>();
        return util(temperatures,s);
    }
}