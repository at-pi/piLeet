
class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()!=b.getValue()?a.getValue()-b.getValue():b.getKey()-a.getKey());
        pq.addAll(map.entrySet());
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> e = pq.poll();
            for(int i=0;i<e.getValue();i++){
                list.add(e.getKey());
            }
        }
        int ret[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            
            ret[i] = list.get(i);
        }
        return ret;
    }
}