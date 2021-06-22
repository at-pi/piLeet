class Solution {
    //int global = 0;
    private int util(int[] arr, int curr,int currsum,int target){
        if(curr==arr.length){
            if(currsum==target)
                return 1;
            return 0;
        }
        return util(arr,curr+1,currsum+(arr[curr]),target)+util(arr,curr+1,currsum+(-1*arr[curr]),target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return util(nums,0,0,target);
        //return global;
    }
}