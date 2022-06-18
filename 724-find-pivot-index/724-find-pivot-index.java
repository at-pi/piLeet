class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int lSum = 0;
        int rSum = sum;
        for(int i=0;i<nums.length;i++){
            rSum -= nums[i];
            if(lSum == rSum){
                return i;
            }
            lSum += nums[i];
        }
        return -1;
    }
}