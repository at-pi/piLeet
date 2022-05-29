class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left<right){
            //System.out.println("left - "+left+" right - "+right);
            int cons = nums[left]+nums[right];
            if(cons == target){
                return new int[]{left+1, right+1};
            }
            else if(cons<target){
                int k = nums[left];
                //System.out.println("incrementing left");
                while(left<nums.length && nums[left] == k){
                    left++;
                }
                //System.out.println("after incrementing left - "+left);
            }
            else{
                int k = nums[right];
                //System.out.println("decrementing right");
                while(right>=0 && nums[right] == k){
                    right--;
                }
                //System.out.println("after incrementing right - "+right);
            }
        }
        return null;
    }
}