class Solution {
    public int secondHighest(String s) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=58){
                if(!list.contains(s.charAt(i)-'0'))
                    list.add(s.charAt(i)-'0');
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        if(list.size()<2)
            return -1;
        else
            return list.get(1);
    }
}