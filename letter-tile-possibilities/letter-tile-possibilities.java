class Solution {
    Set<String> set = new HashSet<>();
    
    private String swap(String s, int l, int r){
        char[] a = s.toCharArray();
        char temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        return String.valueOf(a);
    }
    
    private void generate(String s,int l,int r){
        if(l==r){
            if(!set.contains(s)){
                set.add(s);
                //System.out.println(set);
            }
        }
        for(int i=l;i<r;i++){
            s = swap(s,l,i);
            generate(s,l+1,r);
            s = swap(s,l,i);
        }
    }
    
    private void test(String s, String currS, int curr){
        if(curr>s.length())
            return;
        else if(curr==s.length()){
            //System.out.println(currS);
            generate(currS,0,currS.length());
        }
        else{
            test(s,currS+s.charAt(curr),curr+1);
            test(s,currS,curr+1);
        }
    }
    public int numTilePossibilities(String tiles) {
        test(tiles,"",0);
        return set.size()-1;
    }
}