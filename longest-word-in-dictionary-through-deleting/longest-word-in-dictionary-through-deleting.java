class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        Collections.sort(d, (a,b)-> a.length()!=b.length()? b.length()-a.length() : a.compareTo(b));
        
        for(String str : d){
            int i = 0;
            char[] arr = s.toCharArray();
            for(char c : arr)
                if(i<str.length() && str.charAt(i)==c)
                    i++;
            if(i==str.length())
                return str;
        }
        
        return "";
    }
}