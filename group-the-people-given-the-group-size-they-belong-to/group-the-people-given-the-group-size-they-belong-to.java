class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
            else{
                ArrayList<Integer> temp = map.get(arr[i]);
                temp.add(i);
                map.put(arr[i],temp);
            }
            //System.out.println(map.get(arr[i]));
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> e: map.entrySet()){
            List<Integer> l1 = new ArrayList<>();
            for(int i=0;i<e.getValue().size();i++){
                l1.add(e.getValue().get(i));
                if(l1.size()==e.getKey()){
                    ret.add(new ArrayList<>(l1));
                    l1.clear();
                }
            }
        }
        return ret;
    }
}