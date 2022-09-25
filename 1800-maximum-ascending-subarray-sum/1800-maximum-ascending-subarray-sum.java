class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0];
        int max = curr;
        
        for(int i=1; i<nums.length; i++){
            
            if(nums[i] > nums[i-1]){
                curr += nums[i];
            }
            else{
                curr = nums[i];
            }
            //System.out.println("curr - "+curr);
            max = Math.max(max, curr);
        }
        
        return max;
    }
}