class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int x : nums)
            set.add(x);
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int x = nums[i]+1;
                while(set.contains(x)){
                    x++;
                }
                max=Math.max(max,(x-nums[i]));
            }
        }
        
        return max;
    }
}