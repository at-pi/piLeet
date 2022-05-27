class Solution {
    
    private int search(int[] nums, int start, int end, int target){
        
        if(start>end){
            //System.out.println("here!! start - "+start+" end - "+end);
            if(start < nums.length)
                return start;
            else
                return end+1;
        }
        
        int mid = (start+end)/2;
        
        if(nums[mid] == target){
            return mid;
        }
        
        if(nums[mid] > target){
            return search(nums, start, mid-1, target);
        }
        return search(nums, mid+1, end, target);
    }
    
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
}