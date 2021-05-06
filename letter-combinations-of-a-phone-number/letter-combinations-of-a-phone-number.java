class Solution {
    List<String> list;
    private void util(Map<Integer,String> map, String digits,String curr,int index){
        if(curr.length()==digits.length()){
            list.add(curr);
            return;
        }
        //System.out.println((int)digits.charAt(index)-48);
        //System.out.println(map.get(((int)digits.charAt(index)-48)).length());
        for(int i=0;i<map.get(((int)digits.charAt(index)-48)).length();i++){
            //System.out.println(curr+map.get(((int)digits.charAt(index)-48)).length().charAt(i));
            //System.out.println(curr+map.get((int)digits.charAt(index)-48).charAt(i));
            util(map,digits,curr+map.get((int)digits.charAt(index)-48).charAt(i),index+1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        //System.out.println(digits);
        if(digits.equals("")){
            //System.out.println("sdf");
            return list;
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        util(map,digits,"",0);
        return list;
    }
}