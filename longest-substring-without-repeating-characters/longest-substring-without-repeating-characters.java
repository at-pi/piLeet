class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int j=0;
        int max = 0;
        String curr = "";
        for(int i=0;i<n;i++){
            
            if(!curr.contains(String.valueOf(s.charAt(i)))){
                curr=s.substring(j,i+1);
                //System.out.println("not - "+curr);
                max = Math.max(curr.length(),max);
            }
            else{
                while(s.charAt(j)!=s.charAt(i)){
                    j++;
                }
                j++;
                curr=s.substring(j,i+1);
                //System.out.println("cont - "+curr);
            }
        }
        return max;
    }
}