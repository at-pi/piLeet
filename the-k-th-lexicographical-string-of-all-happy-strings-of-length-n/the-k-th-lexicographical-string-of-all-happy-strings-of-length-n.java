class Solution {
    List<String> list = new ArrayList<>();
    
    private void util(String curr,int n){
        if(curr.length()==n){
            list.add(curr);
            return;
        }
        int k = curr.length();
        if(curr.charAt(k-1)=='a'){
            util(curr+"b",n);
            util(curr+"c",n);
        }
        if(curr.charAt(k-1)=='b'){
            util(curr+"a",n);
            util(curr+"c",n);
        }
        if(curr.charAt(k-1)=='c'){
            util(curr+"a",n);
            util(curr+"b",n);
        }
    }
    
    public String getHappyString(int n, int k) {
        util("a",n);
        util("b",n);
        util("c",n);
        //System.out.println(list);
        if(list.size()<k){
            return "";
        }
        else{
            return list.get(k-1);
        }
    }
}