class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        //List<List<char>> check = new ArrayList<>();
        Map<List<Character>,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            List<Character> check = new ArrayList<>();
            for(int j=0;j<strs[i].length();j++){
                check.add(strs[i].charAt(j));
            }
            Collections.sort(check);
            if(map.containsKey(check)){
                System.out.println(strs[i]);
                List<String> l2 = new ArrayList<>(map.get(check));
                l2.add(strs[i]);
                map.put(check,l2);
            }
            else{
                List<String> l1 = new ArrayList<>();
                l1.add(strs[i]);
                map.put(check,l1);
            }
        }
        for(Map.Entry<List<Character>,List<String>> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}