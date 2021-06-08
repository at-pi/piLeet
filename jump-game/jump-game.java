class Solution {
    //boolean b = false;
    private boolean util(int[] nums, int curr){
        if(curr>=nums.length || nums[curr]==0)
            return false;
        if(curr==nums.length-1)
            return true;
        boolean bool = false;
        for(int i=1;i<=nums[curr];i++){
            bool = bool || util(nums,curr+i);
            if(bool==true)
                return true;
        }
        return bool;
    }
    
    public boolean canJump(int[] nums) {
        int minInd = nums.length-1;
        int curr = minInd-1;
        while(curr>=0){
            //System.out.println(curr + "-minInd-" + minInd);
            if(curr+nums[curr]>=minInd){
                minInd = curr;
                curr--;
            }
            else{
                curr--;
            }
        }
        
        return minInd==0;
    }
}