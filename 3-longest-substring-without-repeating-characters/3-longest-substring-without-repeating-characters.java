class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i=0;
        int j=0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        
        while(j<s.length()){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }
            //System.out.println("after removing - "+set);
            set.add(s.charAt(j));
            j++;
            if(set.size() > maxLength){
                maxLength = set.size();
            }
            //System.out.println("after insertion of j - "+j+" "+set);
        }
        return maxLength;
    }
}