class Solution {
    
    private Map<Integer, Integer> hashMap(String s){
        Map<Integer, Integer> map = new HashMap<>();
        int[] hash = new int[256];
        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i)]++;
        }
        for(int i=0; i<256; i++){
            if(map.containsKey(hash[i])){
                map.put(hash[i], map.get(hash[i])+1);
            }
            else{
                map.put(hash[i],1);
            }
        }
        map.remove(0);
        return map;
    }
    
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        
        
        Map<Character,Character> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            else{
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i),t.charAt(i));
            }
            //System.out.println(map);
        }
        return true;
    }
}