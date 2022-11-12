class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]){
                int idx = s.pop();
                ans[idx] = i-idx;
            }
            s.push(i);
        }
        return ans;
    }
}