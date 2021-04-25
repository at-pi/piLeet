class Solution {
    List<String> list = new ArrayList<>();
    public void util(List<Character> tl,String s,int curr){
        //System.out.println((int)s.charAt(curr));
        if(curr==s.length()){
            String str="";
            for(int i=0;i<tl.size();i++){
                str+=tl.get(i);
            }
            list.add(str);
            //System.out.println(str);
            return;
        }
        if((int)s.charAt(curr)<=90 && (int)s.charAt(curr)>=65){
            // System.out.println("hi");
            tl.add(s.charAt(curr));
            util(tl,s,curr+1);
            tl.remove(tl.size()-1);
            //System.out.println((char)((int)s.charAt(curr)+32));
            tl.add((char)((int)s.charAt(curr)+32));
            util(tl,s,curr+1);
            tl.remove(tl.size()-1);
        }
        else if((int)s.charAt(curr)<=122 && (int)s.charAt(curr)>=97){
            // System.out.println("hi");
            tl.add(s.charAt(curr));
            util(tl,s,curr+1);
            tl.remove(tl.size()-1);
            //System.out.println((char)((int)s.charAt(curr)+32));
            tl.add((char)((int)s.charAt(curr)-32));
            util(tl,s,curr+1);
            tl.remove(tl.size()-1);
        }
        else{
            // System.out.println("hala madrid");
            tl.add(s.charAt(curr));
            util(tl,s,curr+1);
            tl.remove(tl.size()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<Character> tl = new ArrayList<>();
        util(tl,s,0);
        return list;
    }
}