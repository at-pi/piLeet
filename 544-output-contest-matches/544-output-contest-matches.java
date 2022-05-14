class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(""+i+"");
        }
        while(list.size() != 1){
            List<String> newRound = new ArrayList<>();
            for(int i=0; i<list.size()/2 ; i++){
                newRound.add(("("+list.get(i)+","+list.get(list.size()-i-1)+")"));
            }
            //System.out.println(newRound);
            list = newRound;
        }
        return list.get(0);
    }
}