class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int x = map.get(nums[i]);
                x++;
                map.put(nums[i],x);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int sum=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()==1)
                sum+=e.getKey();
        }
        return sum;
    }
}