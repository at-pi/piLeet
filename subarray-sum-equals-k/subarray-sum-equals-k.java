class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ret = 0;
        int currsum=0;
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            
            if(currsum==k)
                ret++;
            
            if(map.containsKey(currsum-k))
                ret+=map.get(currsum-k);
            
            if(map.get(currsum)==null){
                map.put(currsum,1);
            }
            else{
                map.put(currsum,map.get(currsum)+1);
            }
        }
        return ret;
    }
}