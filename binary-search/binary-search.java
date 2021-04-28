class Solution {
    public int bin(int[] nums,int target, int left, int right){
        if(left>right)
            return -1;
        int mid = (left+right)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            return bin(nums,target,left,mid-1);
        else
            return bin(nums,target,mid+1,right);
    }
    public int search(int[] nums, int target) {
        return bin(nums,target,0,nums.length-1);
    }
}