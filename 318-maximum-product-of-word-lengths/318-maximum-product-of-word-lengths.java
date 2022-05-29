class Solution {
    
    private boolean check(Set<Character> set, String str){
        for(char c: str.toCharArray()){
            if(set.contains(c))
                return true;
        }
        return false;
    }
    
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i=0; i<words.length; i++){
            Set<Character> set = new HashSet();
            for(char c: words[i].toCharArray()){
                set.add(c);
            }
            for(int j=i+1; j<words.length; j++){
                if(!check(set,words[j])){
                    //System.out.println("got em - "+words[i]+" "+words[j]);
                    int k = words[i].length()*words[j].length();
                    ans = Math.max(ans,k);
                }
            }
        }
        return ans;
    }
}