class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            return new String(sArr);
        }
        
        String ans = s;
        for(int i=0; i<s.length(); i++){
            String temp = s.substring(i) + s.substring(0,i);
            if(ans.compareTo(temp) > 0) ans = temp;
        }
        return ans;
    }
}