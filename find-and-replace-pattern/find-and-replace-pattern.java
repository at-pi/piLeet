class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
         List<String> list =new ArrayList<String>();
        HashMap<Character,Character> map=null;
        for(int i=0;i<words.length;i++){
            map=new HashMap<Character,Character>();
            boolean revert=true;
            for(int j=0;j<words[i].length();j++){
                if(!map.containsKey(pattern.charAt(j))){
                    if(!map.containsValue(words[i].charAt(j))){
                        map.put(pattern.charAt(j),words[i].charAt(j));
                    }
                    else{
                        revert=false;
                    }
                }
                   else{
                       if(map.get(pattern.charAt(j))!=words[i].charAt(j)){
                           revert=false;
                       }
                   }
        }
                   if(revert==true){
                       list.add(words[i]);
                   }
    }
                   return list;
    }
}