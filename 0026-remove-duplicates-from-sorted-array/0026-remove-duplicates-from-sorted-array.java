class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int i=0;
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            nums[i++] = itr.next();
        }
        return set.size();
    }
}