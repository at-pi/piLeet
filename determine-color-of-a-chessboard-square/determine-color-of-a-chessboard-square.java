class Solution {
    public boolean squareIsWhite(String str) {
        List<Character> lc = new ArrayList<>();
        lc.add('a');
        lc.add('c');
        lc.add('e');
        lc.add('g');
        List<Character> lo = new ArrayList<>();
        lo.add('b');
        lo.add('d');
        lo.add('f');
        lo.add('h');
        int i = Integer.parseInt(String.valueOf(str.charAt(1)));
        if(lc.contains(str.charAt(0))){
            
            if(i%2==0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(i%2==0){
                return false;
            }
            else{
                return true;
            }
        }
    }
}