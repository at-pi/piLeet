class Solution {
    public String restoreString(String s, int[] indices) {
        Map<Integer,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(indices[i],s.charAt(i));
        }
        //System.out.println(map);
        PriorityQueue<Map.Entry<Integer,Character>> pq = new PriorityQueue<>((a,b) -> a.getKey()-b.getKey());
        pq.addAll(map.entrySet());
        String str = "";
        while(!pq.isEmpty()){
            str =  str+pq.poll().getValue();
        }
        return str;
    }
}